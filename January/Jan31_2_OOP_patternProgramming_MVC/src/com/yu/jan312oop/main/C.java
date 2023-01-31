package com.yu.jan312oop.main;

// Controller
//		상황판단해서 V가 필요하면 V꺼내고, M이 필요하면 M꺼내고
//		흐름제어
//		프로그램 진입점
//		PL급 개발자(대장급)
public class C {

	public static void main(String[] args) {
		int n = V.getNo();
		String result = M.judge(n);
		V.print(result);
	}
}
