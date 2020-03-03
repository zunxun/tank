package com.zx.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame
{
	Tank myTank = new Tank(200, 200, Dir.DOWN,this);
	List<Bullet> bullets = new ArrayList<Bullet>();
	Bullet b = new Bullet(300, 300, Dir.DOWN, null);
	static final int GAME_WIDTH = 800,GAME_HEIGHT = 600;
	

	public TankFrame()
	{

		setSize(GAME_WIDTH, GAME_HEIGHT);
		setResizable(false);// 能否改变大小
		setTitle("tank  war"); // 标题
		setVisible(true);

		this.addKeyListener(new MyKeyListener());

		addWindowListener(new WindowAdapter() // 匿名类 添加监听器
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

	}
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	@Override
	public void paint(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量："+bullets.size(), 10, 60);
		g.setColor(c);
		
		myTank.paint(g);
		for (int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).paint(g);
		}
		
	}

	class MyKeyListener extends KeyAdapter
	{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;// 四个键组合状态确定方向，在方向确定坐标值

		@Override
		public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();
			switch (key)
			{
			case KeyEvent.VK_LEFT:// 向左
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;

			default:
				break;
			}
			// x += 200;
			// repaint();//默认调用paint
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			int key = e.getKeyCode();
			switch (key)
			{
			case KeyEvent.VK_LEFT:// 向左
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
				
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				break;
			

			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir()
		{

			if (!bL && !bU && !bR && !bD)
				myTank.setMoving(false);
			else
			{
				myTank.setMoving(true);

				if (bL)
					myTank.setDir(Dir.LEFT);
				if (bU)
					myTank.setDir(Dir.UP);
				if (bR)
					myTank.setDir(Dir.RIGHT);
				if (bD)
					myTank.setDir(Dir.DOWN);
			}

		}

	}
}
