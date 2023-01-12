package com.yu.jan122oop.Car;

public class Sedan extends Car {

	Sedan() {
	}

	Sedan(int no) {
		super(no);
	}

	@Override
	public void print() {
		System.out.println("세단");
		super.print();
	}
}
