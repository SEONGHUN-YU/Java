package com.yu.jan115oop.human;

// human
// main
// 카테고리별로 정리하고 싶은데

// protected/안쓴거 : 다른 패키지에서 못 쓰잖아 -> public으로 해야지 => public 절대 하지마!

// human패키지에 멤버변수와 메소드들
// main패키지에서 써야되니까
// public? 절대 안 됨 하지마라 -> 현장에서는 무조건 private

// encapsulation - 캡슐화
//		권한없는 사람이 데이터 함부로 못 건들게 하려고
//		기본사항이며, 이 바닥의 문화임
//		기본적으로 class는 캡슐화를 해서 만든다

// 멤버변수를 public줘서 외부에서 직접 건들게 만들면
// 잘못된 데이터가 들어갈 위험성이 있다 -> 따라서 private으로 해라

public class Human {
	// 1. 멤버변수 (private줘서 외부 접근 막기, 무조건 필수)
	private String name;
	private int age;

	public Human() {
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;

	}

	// 2. 권한있는 사람이 접근할 수 있는 통로를 하나 만들어두자
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		// 3. 그 통로에 안전장치 설치(다양한 방법)
		if (age < 0) {
			age *= -1;
		}
		this.age = age;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(age);
	}
}
