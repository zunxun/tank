package com.zx.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame
{
	int x = 200, y = 200;

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
		g.fillRect(x, y, 50, 50);
		x += 10;
		y += 10;
	}

	class MyKeyListener extends KeyAdapter
	{

		@Override
		public void keyPressed(KeyEvent e)
		{
			System.out.println("key pressed");
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			System.out.println("key released");
		}

	}
}
