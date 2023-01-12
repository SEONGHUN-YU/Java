package com.yu.jan122oop.soldesk;

// 객체가 필요없다 : static method 기반으로

// 객체가 필요하다
//		딱 하나 필요함 : singleton 패턴
//		여러개
//			작정하고 대량으로 만들어야 될 경우에, 번호같은 거 뭔가 자동으로 안 되나? : factory패턴
//			그 정도는 아니고 적당한 양 : 평소대로

public class Student {
	private int no;
	private String name;
	private int age;
	private String address;

	// factory 패턴 과정
	
	// 1. 생성자를 안쓴거 모드로 해준다 (이 효과로 인해 다른 패키지에서 객체 못 만듬)
	// 2. 같은 패키지에 공장역할을 할 클래스를 만든다 <- 핵심 : 학원에 입학하려면 안영광에게 상담을 받아야 한다
	// 라는 느낌으로 객체지향 프로그래밍을 한 것!? (큰그림 와우...)
	Student() {
	}

	Student(int checkNumber, String name, int age, String address) {
		super();
		this.no = checkNumber;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getCheckNumber() {
		return no;
	}

	public void setCheckNumber(int checkNumber) {
		this.no = checkNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void showInfo() {
		System.out.println(no);
		System.out.println(name);
		System.out.println(age);
		System.out.println(address);
	}

}
