package com.yu.jan113oop.main;
// Java에서의 상속 특징
// *1. 하위클래스(Firewall)객체 만들면
//		상위클래스 기본생성자를 자동으로 부름
// *2. 생성자는 상속 안 됨 -> 필요하다면 각자 만들면 되지 뭐!
//		상속시켜줘봐야 딱히 도움이 안 되는 경우도 많으니...?

public class Product {
	String name;
	int price;
	String maker;

	// JSP/Spring에서 쓰이기도 하고, 안 쓸 거여도,기본생성자가 없으면 꽤 문제가 생긴다
	public Product() {
	}

	public Product(String name, int price, String maker) {
		super(); // *1번 상황을 명시 해놓은 것 (이거 없어도 그대로 함)
		this.name = name;
		this.price = price;
		this.maker = maker;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(maker);

	}
}
