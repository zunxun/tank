package com.zx.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame
{
	Tank myTank = new Tank(200, 200, Dir.DOWN);
	Bullet b = new Bullet(300, 300, Dir.DOWN);
	

	public TankFrame()
	{

		setSize(800, 600);
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

	@Override
	public void paint(Graphics g)
	{
		myTank.paint(g);
		b.paint(g);

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
