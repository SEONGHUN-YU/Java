package com.yu.jan115oop.main;

import java.util.Scanner;

import com.yu.jan115oop.human.Human;

public class OOPMain {
	public static void main(String[] args) {
		// 홍길동, 30살 사람
		// 정보출력
		Human h = new Human("홍길동", 30);
		h.showInfo();
		System.out.println("-----");
		// 나이는 들고
		// 개명할 수도 있고

		Scanner k = new Scanner(System.in);
		System.out.println("수정할 나이 : ");
		int a = k.nextInt();
//	h.age = a; // 변수에 직접 접근 못하는 게 일반적이다
		System.out.println("-----");
		h.setAge(a);
		h.getAge();
		h.showInfo();
	}
}
