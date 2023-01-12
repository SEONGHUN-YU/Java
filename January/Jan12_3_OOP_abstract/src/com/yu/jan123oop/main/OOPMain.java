package com.yu.jan123oop.main;

import com.yu.jan123oop.hero.Hero;
import com.yu.jan123oop.hero.Hulk;
import com.yu.jan123oop.hero.IronMan;
import com.yu.jan123oop.human.Human;

// static도 가능해보임
// 원래는 singleton 하는 게 맞긴한데 이번엔 하지말아보자

// OOP 정신?
//		클래스를 만들어서 재사용하기 위한 양식인데 하위클래스를 만드는 건
//		OOP와 좀 상반된 성질이라고 볼 수 있다?
public class OOPMain {
	public static void main(String[] args) {
		Human h = new Human() {
			@Override
			public void eat() {
				System.out.println("급식");
			}
		};
		h.eat();
		
		// Java는 객체를 만들면서 클래스까지 만드는 게 됨 (Java만 존재)
		// Hero의 하위클래스
		// Anonymous Inner Class : 익명 내부 클래스

		// a : 클래스명은 모름(대충 캡틴아메리카로 추측되기는 함 <- 먼소리야?)
		// Hero이기는 하다

		// 다형성이 활용된 거라고 보면 된다
		Hero a = new Hero() {
			@Override
			public void attack() {
				// TODO Auto-generated method stub
			}
		};
		/*
		 * { 이 부분의 정체는 Hero의 하위클래스
		 * 
		 * @Override public void attack() { // TODO Auto-generated method stub
		 * 
		 * } }
		 */
		System.out.println("-----");
		
		// 토니, 나이 40, 컴퓨터 = 자비스, 아이언맨
		// 정보출력
		// 공격하기 : 빔 발사
		IronMan i = new IronMan("토니", 40, "자비스");
		i.showInfo();
		i.attack();
		i.eat();
		i.fly();
		System.out.println("-----");

		// 배너, 나이 35, 바지사이즈 = 99, 헐크
		// 정보출력
		// 공격하기 : 주먹질 출력
		Hulk hk = new Hulk("배너", 35, 99);
		i.showInfo();
		i.attack();

	}
}
