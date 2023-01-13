package com.yu.jan133eh.main;

import java.util.Random;
import java.util.Scanner;

// 저기 사과가 하나 있다
// There is an apple

// ㅁ너아ㅣㅁㄴ어
// 번역해봐 -> 원본이 정상이어야 번역도 할 수 있다

// 설계 - 번역(개발)-> .java
// .java - 번역(compile)-> .class
// .class - 압축-> .jar(Java프로그램 최종산출물)
// .jar - 실행 ->

// error : Java문법에 안 맞게 써서
//			컴파일(기계어로 번역)이 불가능한 상황

// warning : 정리 안 된 소스(드러운 코드)
//			실행에 문제는 없음
//			개발자 잘못, 정리해주는 게 좋을 것

// exception : 정상적인 프로그램이긴한데
//				뭔가 외부적인 요인에 의해 실행에 문제가 생기면
//				그게 개발자 잘못? -> 아니지..
//				그 상황에 대응해줄 수 있는 사람 : 개발자

// 수학 이론			
//		나누기 0은 존재하지 않는다

// 예외처리 : 
// 1) 직접처리 [try - catch - finally]
// => 대응방법까지 들어간다 : 나중에 수정 못할 수도 있어서 그건 단점임
//		try {
//			여기 실행하다가
//		} catch (A예외객체명 변수명) {
//			A예외가 발생하면 여기
//		} catch (B예외객체명 변수명) {
//			B예외가 발생하면 여기
//		} ...
//		} finally {
//			return보다 먼저임! <- 매우 중요
//			예외가 터졌든 말든 공통적으로 무조건 실행되는 부분
//		}

// 2) 미루기 [throws(던지기)] <- 실전에선 이게 더 많이 쓰임, 주력임
// => 대응방법은 쓰는 쪽에서 결정한다

// 1. 프로젝트가 바뀌면 대응방법도 바뀔텐데?
// 2. 클래스를 작업할 신입개발자가 대응? 권한도 없으면서? 월권행위지!
// => 따라서 1)보다 2)가 더 주력으로 쓰인다
// 1)은 사수급 이상이 메인에다 적는 게 일반적!

public class EHMain {
	public static void printMath(int a, int b) {
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		// 에러는 첫줄에 핵심내용이 다 있다, 그 뒤는 그다지 ?
		try {
			System.out.println("나누기"); // <- 에러가 없다면 문제없이 실행됨
			System.out.println(a / b); // <- 이 부분이 에러라면 그 부분과 그 밑으로 다 패스
			System.out.println("여긴 패스된다");
		} catch (Exception e) { // 에러 종류도 설정가능, 기본설정은 모든 에러 때 실행됨
			e.printStackTrace(); // 개발자용 <- 에러 종류가 뭔지 맨 앞으로 메시지 빼주는 거
			System.out.println("0으로는 나눌 수 없음");
		} finally {
			System.out.println("끄읏");
		}
	}

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("x : ");
		int x = k.nextInt();
		System.out.println("y : ");
		int y = k.nextInt();
		System.out.println("-----");
		printMath(x, y);
		k.close();

		// 대충 이런식
//		try {
//			System.out.println(x / y);
//			int[] ar = { 123, 123123 }; // 0,1 밖에 없음
//			System.out.println(ar[y]); // 그런 거 없어
//		} catch (ArithmeticException e) {
//			System.out.println("0은 나눌 수 없어");
//		} catch (ArrayIndexOutOfBoundsException e) { // catch는 여러번 쓸 수 있다
//			System.out.println("올바른 배열 값을 넣어");
//		}

		// 나 : 개발자
		// 동생 : 잼민이
		// 정수 2개 넣으면, 사칙연산결과 출력하는 프로그램
	}
}
