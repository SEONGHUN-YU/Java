package com.yu.jan122oop.Car;

public class Car {
	private int no;

	Car() {
	}

	Car(int no) {
		super();
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void print() {
		System.out.println(no);
		System.out.println("만들었다");
	}
}
