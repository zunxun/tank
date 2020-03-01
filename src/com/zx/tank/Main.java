package com.zx.tank;
//
public class Main
{

	public static void main(String[] args) throws InterruptedException
	{
		TankFrame tf = new TankFrame();
		while (true)
		{
			Thread.sleep(50);//每隔50毫秒窗口重画一次，就会调用paint方法x += 10
			tf.repaint();
		}
		
		
	}
	

}
