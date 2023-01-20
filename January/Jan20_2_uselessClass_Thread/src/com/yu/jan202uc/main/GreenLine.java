package com.yu.jan202uc.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GreenLine implements Runnable { // 실전형 방법! 중요, 사실상 주력
	@Override
	public void run() {
		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		jf.setLocation(300, 0); // <- BlueLine 옆에 나오게 해준 것
		jf.setSize(300, 300);
		jf.setVisible(true);
		for (int i = 0; i < 10; i++) { // 동시에 작업 하고싶은 소스를 가져온다
			jta.append("ㅇ\r\n");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
