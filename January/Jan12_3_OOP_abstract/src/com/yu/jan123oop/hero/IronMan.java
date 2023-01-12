package com.yu.jan123oop.hero;

import com.yu.jan123oop.flyer.Flyer;
import com.yu.jan123oop.human.Human;

// 객체 - 상품 - 컴퓨터 - 노트북 : 다단상속

// 다중상속 : 여러 클래스로부터 상속 받을 수 있나?
// 되는 언어, 안 되는 언어 있음 <- Java는 다중상속 불가능 (대부분의 언어들은 불가능하긴 함)
// Python은 된다고 한다...
// 아이언맨 is a 어벤져스 - o
// 아이언맨 is a 사람 - o
// 아이언맨 is a 날아다니는 존재(Flyer)

// 정식 다중상속은 안 되는데
// 마이너버전(약간 구린) 다중상속이 Java도 되긴 된다고 한다

// implements : 구현 => interface 상속받을 때 쓰는 거

public class IronMan extends Hero implements Human, Flyer {
	private String com;

	public IronMan() {
	}

	public IronMan(String name, int age, String com) {
		super(name, age);
		this.com = com;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(com);
	}

	@Override
	public void attack() {
//		super.attack(); <- 사실상 지워도 된다 부모클래스에 아무것도 없어서... 의미 무
//		abstract method라서 이젠 지워야 한다 (↑배우기 전 내용)		
		System.out.println("빔 발사");
	}

	@Override
	public void eat() {
		System.out.println("냠");
	}

	@Override
	public void fly() {
		System.out.println("슝");
	}

}
