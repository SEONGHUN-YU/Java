package com.yu.jan202uc.main;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// ...
// JVM이 thread를 만들어서 UCMain.main(...)으로 보냄 (작업의 흐름)

// multi-thread programming
//		JVM이 만들어주는 흐름 : main thread
//		사람이 수동으로 만드는 흐름 : sub thread 
public class UCMain {
	public static void main(String[] args) {
		BlueLine bl = new BlueLine();
		// bl.run(); 이거 말고!
		bl.start(); // 새로운 thread 만들어서 run으로 보내기

		Thread t = new Thread(new GreenLine());
		t.start();

		Thread t2 = new Thread() { // 3번째 방법? 사실상 bl이랑 같은 방법인데 문법만 다른 거라고 한다
			@Override // 익명 내부 클래스를 활용하는 것
			public void run() {
				super.run();

				JFrame jf = new JFrame();
				JTextArea jta = new JTextArea();
				jf.add(jta);
				jf.setLocation(600, 0); // <- GreenLine 옆에 나오게 해준 것
				jf.setSize(300, 300);
				jf.setVisible(true);
				for (int i = 0; i < 10; i++) { // 동시에 작업 하고싶은 소스를 가져온다
					jta.append("ㅂ\r\n");
					try {
						Thread.sleep(300);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		t2.start();
		
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
