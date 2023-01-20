package com.yu.jan202uc.main;

// mainThread가 끝난다고 해서 subThread가 자동종료되지는 않는다

public class UCMain2 {
	public static void main(String[] args) {
		Thread t = new Thread(new PinkLine());
		t.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("ㅋ");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
