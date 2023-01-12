package com.yu.jan123oop.hero;
// 추상

// abstract class
//		객체 못 만드는 클래스
//		abstract method를 하나라도 가지고 있으면 추상클래스여야 한다
//		영웅이 어떻게 생겼는데? => 추상적인 개념일 뿐, 실체가 있는 게 아니다
//		=> 객체를 만들 일이 없지

// abstract method
//		미완성 메소드
//		하위클래스에서 반드시 오버라이딩해야 된다 <- 이걸 안 하면 반드시 error가 난다
public abstract class Hero {
	private String name;
	private int age;

	public Hero() {
	}

	public Hero(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

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
		this.age = age;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(age);
	}

	public abstract void attack(); // <- 중괄호 없음 중요
	// 뭐라쓰지? 딱히 쓸 말 없다 => 그럼 자료형 앞에 abstract
}
