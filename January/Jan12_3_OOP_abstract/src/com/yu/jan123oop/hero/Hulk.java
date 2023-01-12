package com.yu.jan123oop.hero;

public class Hulk extends Hero {
	private int pants;

	public Hulk() {
	}

	public Hulk(String name, int age, int pants) {
		super(name, age);
		this.pants = pants;
	}

	public int getPants() {
		return pants;
	}

	public void setPants(int pants) {
		this.pants = pants;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(pants);
	}

	@Override
	public void attack() {
		System.out.println("주먹질!");
	}

}
