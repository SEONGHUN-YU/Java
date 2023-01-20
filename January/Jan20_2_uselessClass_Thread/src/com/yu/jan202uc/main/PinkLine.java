package com.yu.jan202uc.main;

public class PinkLine implements Runnable {
	@Override
	public void run() {

		while (true) {
			System.out.println("ㅎ");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
