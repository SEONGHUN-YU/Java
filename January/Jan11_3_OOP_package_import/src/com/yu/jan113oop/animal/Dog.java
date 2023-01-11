package com.yu.jan113oop.animal;

public class Dog {
	String name;
	int age;

	public Dog() {
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(age);
	}

}
