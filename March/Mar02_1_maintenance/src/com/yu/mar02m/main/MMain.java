package com.yu.mar02m.main;

import java.util.Scanner;

public class MMain {
	// 코딩 -> 컴파일 -> 압축 -> .jar(.war)
	// (+ 실행 편하게 하라고 .bat도)

	// 기존에 쓰던 프로그램 못 씀 -> 보수해야함
	// 1. 마트 사장님은 Java를 못 함
	// 2. 할 줄 알더라도, 사장님은 .jar만 가지고 있어서 수정 불가능
	// -> 사장님은 보수 못 함
	// -> 그 때 개발자에게 연락 -> 개발자가 소스 수정
	// 컴파일 -> 압축 -> .jar (+.bat도) -> 다시 마트측에 줘야
	public static void getPoint() {
		Scanner k = new Scanner(System.in);
		System.out.print("물건금액 : ");
		int purchase = k.nextInt();
		double point = purchase / 100 * 0.5;
		System.out.printf("적립포인트 : %.0f원\r\n", point);
		System.out.print("종료하려면 아무 글자나 입력하세요 : ");
		k.next();
		k.close();
	}

	public static void main(String[] args) {
		getPoint();
	}
}
