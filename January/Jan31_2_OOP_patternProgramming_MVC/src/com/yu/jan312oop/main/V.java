package com.yu.jan312oop.main;

import java.util.Scanner;

// View
//		실제 사용자에게 보여지는 영역
//		입력받고 출력하고
//		디자이너, front-end 개발자
public class V {

	public static int getNo() {
		Scanner k = new Scanner(System.in);
		System.out.println("숫자 : ");
		return k.nextInt();
	}

	public static void print(String result) {
		System.out.println(result);
	}
}
