package com.yu.jan135uc.main;

// 1. 숫자들은 기본형이라 메소드가 없긴한데
// 2. 데이터가 heap에 있어야 하는 경우가 옴
// ↓ 그럴 때 쓰는것
// Wrapper Class
// => 기본형들의 객체형
public class UCMain3 {
	public static void main(String[] args) {
		int i = 10;
		Integer ii = new Integer(10);
		// int만 빼고 나머진 다 첫 글자를 대문자로 하면 객체형이 됨

		double d = 23.123;
		Double dd = new Double(23.123);

		boolean b = true;
		Boolean bb = new Boolean(true);
		System.out.println("-----");

		// 기본형 -> 객체형 바꾸는 법
		int a = 30;
		Integer aa = new Integer(a); // 생성자 쓰면 된다, 원래 문법

		// 객체형 -> 기본형 바꾸는 법
		Double cc = new Double(123.1211);
		double c = cc.doubleValue(); // .xxValue()를 쓰면 된다
		System.out.println("-----");

		// 기본형 -> 객체형(자동 : auto-boxing)
		boolean e = false;
		Boolean ee = e; // 생성자 안 쓰고 그냥 이래도 되긴 한다, 신형 문법

		// 객체형 -> 기본형(자동 : auto-unboxing)
		Integer ff = new Integer(5);
		int f = ff; // 그냥 이래도 된다
		System.out.println("-----");

		// 기본형 -> String
		int g = 123;
		String gg = g + ""; // 이렇게 바꾸면 됨
		String gg2 = String.format("%d", g); // 이런 방법도 있음

		// String -> 객체형 -> 기본형 // 바로 기본형으로는 못 바꾼다
		String h = "12.334";
		Double hh = Double.parseDouble(h); // 클래스명.parseXX()를 쓴다
		double hhh = hh.doubleValue();

		String j = "456";
		int jjj = Integer.parseInt(j); // 매우 생략된 형태

	}
}
