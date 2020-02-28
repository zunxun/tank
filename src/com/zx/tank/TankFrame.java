package com.zx.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame
{
	public TankFrame()
	{

		setSize(800, 600);
		setResizable(false);// 能否改变大小
		setTitle("tank  war"); // 标题
		setVisible(true);

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
		g.fillRect(200, 200, 50, 50);
	}
}
