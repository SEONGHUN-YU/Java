package com.yu.jan202uc.human;

// socket
//		빅데이터+AI -> 웹
//		실시간 - 빅데이터는 사실 실시간 그다지 필요없어
//		나는 웹에 실시간 하겠다 - 웹소켓!?

// thread
//		웹사이트
//		여러 명이 동시에 쓰는 건데
//		누구 하나가 접속할 때마다 thread가 생긴다
//		JSP/Spring : 알아서 함

// critical section setting
// 임계영역설정
// 여러 Thread가 뭐 하나를 공유하는 상황일 때
// 한 번에 한 Thread만 접근 할 수 있도록 설정하는 것

public class Human {
	private String brain;

	// synchronized method <- 이러면 아까 그 문제가 안 터진다
	// Thread 몇개가 돌고 있든 상관없이
	// 다른 synchronized method가 실행 불가
	private synchronized void sayName() {
		for (int i = 0; i < 10; i++) {
			brain = "홍길동";
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("이름 : " + brain);
		}
	}

	private synchronized void sayHobby() {
		for (int i = 0; i < 10; i++) {
			brain = "운동";
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("취미 : " + brain);
		}
	}

	public void introduce() {
		Thread t = new Thread() {
			@Override
			public void run() {
				super.run();
				sayName();
			}
		};
		t.start();

		sayHobby();
	}
}
