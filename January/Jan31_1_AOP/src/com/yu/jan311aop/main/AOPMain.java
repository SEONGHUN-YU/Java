package com.yu.jan311aop.main;

import com.yu.jan311aop.human.Human;

// PP (Procedural Programming)
//		조건문/반복문/... 순서에 맞게 잘 써서
//		결과 잘 내자
// ------------------------------
// OOP (Object Oriented Programming)
//		객체로 실생활을 묘사해서
//		유지보수 좋게 하자
// ------------------------------
// AOP (Aspect Oriented Programming)
//		관점지향 프로그래밍
//		OOP를 다른 관점에서 보아, 공통된 것들 정리

// Spring가서 AOP ?!
public class AOPMain {
	public static void main(String[] args) {
		Human h = new Human();
		h.goToMart();
		System.out.println("-----");
		h.goToPark();
		System.out.println("-----");
		h.goToSchool();

	}
}
