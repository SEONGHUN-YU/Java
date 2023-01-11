package com.yu.jan113oop.main;

import java.util.Random;

import com.yu.jan113oop.animal.Dog;
import com.yu.jan113oop.product.Scanner;

//		OMain2.java에서 Scanner는 무조건 내가 만든 거
//		절대로 java.util의 Scanner는 안 쓸 거다란 의미

// 패키지명 생략가능한 경우 3개
//		자바의 기본패키지 소속이면 안 써도 됨(java.lang)
//		같은패키지 소속이면 안 써도 됨
//		import했으면 생략해도 됨

// ctrl + shift + o => import를 정리해주는 단축키 (없어진 것도 다시 만들어줌)
// 필요없는 걸 지워주기도 함

public class OOPMain2 {
	public static void main(String[] args) {
		Random r = new Random();
		java.lang.String q = "네";
		Pen p = new Pen();
		Scanner s = new Scanner();
		java.util.Scanner k = new java.util.Scanner(System.in);
		
		Dog d = new Dog("후추", 3);
//		d.age = 2; // ??? 왜 수정이 안 되지?
		d.showInfo();
		// 후추, 3살, 개
		// 출력
		
		
	}
}
