package com.yu.jan122oop.Car;

public class Truck extends Car {

	Truck() {
		super();
	}

	Truck(int no) {
		super(no);
	}

	@Override
	public void print() {
		System.out.println("트럭");
		super.print();
	}

}
