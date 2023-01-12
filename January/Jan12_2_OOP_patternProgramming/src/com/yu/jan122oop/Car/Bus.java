package com.yu.jan122oop.Car;

public class Bus extends Car {

	Bus() {
		super();
	}

	Bus(int no) {
		super(no);
	}

	@Override
	public void print() {
		System.out.println("버스");
		super.print();
	}

}
