package com.yu.jan113oop.main;

import java.util.Scanner;

// 클래스명이 중복되면 곤란
// 자바의 특성상 거시적으로 봤을 때 중복이 안 되게 짓는 게 불가능
// 클래스명이 같을 때 구분할 수단은?!

// package / import
// 		클래스명 중복될 때 구분할 수단
//		클래스는 반드시 어떤 패키지에 소속 시켜라 <- 앞으로 계속!
//		JSP랑 Spring 가면 패키지에 안 넣어뒀을 때 오류를 야기할 걸?
//		패키지명이 중복되면?? -> 망하는 거다...
//			=> 패키지명 전세계적으로 중복 안 되게 지어야 된다고 한다;
//		단순 정리차원에서 쓰는 거 - X, 대충 지으면 혼난다;
//		물론 파일정리 효과도 있긴하니까 이름 지을 때 활용하자
//		=> 그럼 어떡하는데? 보통 4자리 이상 쓴다고 한다 (헐..)
//		=> com.회사명.프로그램명.카테고리 <- 같은 방법을 쓴다고 한다 내 ID를 쓴다던지?
//		회사 홈페이지 주소를 거꾸로 쓴다던지?
//		a.com => com.a
//		b.co.kr => kr.co.b 
//		c.go.kr	=> kr.go.c


// 패키지
//		클래스

// java.util
//		Scanner

// 최종 문법은!
// 객체 만들기
//		패키지명.클래스명 변수명 = new 패키지명.생성자;

// 패키지명 생략가능
//		자바의 기본패키지 소속이면 안 써도 됨(java.lang)


public class OOPMain {
	public static void main(String[] args) {
		
		java.lang.String z = "z";
		java.util.Scanner k = new java.util.Scanner(System.in);
		com.yu.jan113oop.product.Scanner s = new com.yu.jan113oop.product.Scanner();

	}
}
