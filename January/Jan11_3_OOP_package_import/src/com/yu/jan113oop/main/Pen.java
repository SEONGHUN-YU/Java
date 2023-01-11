package com.yu.jan113oop.main;

public class Pen extends Product {
	String color;

	public Pen() {
	}

	public Pen(String name, int price, String maker, String color) {
		super(name, price, maker);
		this.color = color;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(color);
	}
}
