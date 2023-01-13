package com.yu.jan133eh.main;

import java.util.Scanner;

import com.yu.jan133eh.calculator.Calculator;

public class EHMain2 {
	public static void main(String[] args) {
		// 계산기
		// 정수 2개를 넣으면 나눈 몫을 구해주는 메소드
		Scanner k = new Scanner(System.in);
		System.out.println("x : ");
		int x = k.nextInt();
		System.out.println("y : ");
		int y = k.nextInt();
		System.out.println("-----");

//		1) 직접처리
//		int z = Calculator.divide(x, y);
//		System.out.println(z);

//		2) 미루기 <- 호출한 쪽(이 경우는 main method에서 직접처리)
//		그래서 main method에 아래 같이 적으면 된다
		try {
			int z = Calculator.divide2(x, y);
			System.out.println(z);
		} catch (Exception e) {
			System.out.println("나누기 0은 없어");
		}
	}
}
