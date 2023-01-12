package com.yu.jan121oop.product;

// 패키지명은 전세계적으로 중복 안 됨
// 안드로이드 앱 ID : 패키지명

public class Product {
	private String name;
	private int price;
	private boolean soldout;

	public Product() {
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isSoldout() {
		return soldout;
	}

	public void setSoldout(boolean soldout) {
		this.soldout = soldout;
	}

	public void showinfo() {
		System.out.println(this.name);
		System.out.println(this.price);
	}
}
