package com.yu.jan121oop.main;

import com.yu.jan121oop.product.Book;
import com.yu.jan121oop.product.Food;
import com.yu.jan121oop.product.Product;

// OOP
//	빨라지나? -> No
//	작업량 감소? -> No
//	소스 알아보기 편해짐 -> 유지보수 용이
//		객체라는 걸 써서 실생활을 묘사
//	코드 재사용이 편함
//		클래스 단위로 작업
//	데이터를 안전하게 다룸
//		캡슐화
// 		정보은닉 : 접근지정자를 써서 최대한 감추는 방향으로 작업
//		다형성


// 책 is a 상품
// 음식 is a 상품
// 상품클래스로부터 상속받는 책클래스
// 상품클래스로부터 상속받는 음식클래스

// 클래스명 중복될 때 구별해야하니 package 정리해라

// 캡슐화

// 다형성 polymorphism
//		상위타입 변수에 하위타입 담는 게 가능

//		정적로딩(static loading) - 다형성이 안 됨
//			변수 만들 때 최종적으로 자료형이 결정되는 것
//		동적로딩(dynamic loading) - Java
//			정말로 실행될 때 최종적으로 자료형이 결정되는 것
public class OOPMain {
	public static void main(String[] args) {
		// 변수 : 데이터 담는 그릇
		// 자료형 변수명 = 데이터;
		// 자료형하고 데이터하고 안 맞으면 안 됨

		// 1. Food v = new Food(); - o
		// 2. Food v2 = new Book(); - x : v2는 음식 담는 그릇인데 책을 담으면 안 되지;
		// 3. Food v3 = new Product(); - x : v3는 음식 담는 그릇인데 상품을 담으면 안 되지;
		// ↓ 사람이 들어올 수 있는 건물에 여자가 들어가면 안 되나? => 되잖아! 마찬가지다
		
		Product v4 = new Food(); // - o : v4는 상품 담는 그릇인데 음식을 담으면 ??? 헐 이게 되네...
		// v4의 정체는 뭘까? Product/Food 중에 Food이다 <- 매우 중요한 개념일 듯하다
		v4.showinfo();
		
		
		System.out.println("-----");
		// 이것이 자바다, 30000, 홍길동 저서, 책
		// 정보출력
		Book b = new Book("이것이 자바다", 30000, "홍길동");
		b.showinfo();
		System.out.println("-----");

		// 딸기맛요구르트, 1000, 유통기한 내일, 음식
		// 정보출력
		Food f = new Food("딸기맛요구르트", 1000, "내일");

		// 값 바꿔줄 때 set, 값 출력하거나 사용할 때 get
		// f.price = 1500; <- 이건 실전에선 절대 안 쓴다
		f.setPrice(1500); //
		// System.out.println(f.name); <- 절대 안 씀
		System.out.println(f.getName());
		f.showinfo();

	}
}
