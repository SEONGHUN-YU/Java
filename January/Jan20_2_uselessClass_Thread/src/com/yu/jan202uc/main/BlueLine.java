package com.yu.jan202uc.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BlueLine extends Thread { // 이론적인 방법, 실용성이 없음, 상속라인을 막아버리기 때문
	@Override
	public void run() {
		super.run();

		JFrame jf = new JFrame();
		JTextArea jta = new JTextArea();
		jf.add(jta);
		jf.setSize(300, 300);
		jf.setVisible(true);
		for (int i = 0; i < 10; i++) { // 동시에 작업 하고싶은 소스를 가져온다
			jta.append("ㅎ\r\n");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
