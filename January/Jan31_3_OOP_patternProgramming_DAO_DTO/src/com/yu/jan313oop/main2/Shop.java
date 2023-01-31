package com.yu.jan313oop.main2;

public class Shop {
	private int no;
	private String name;
	private String kind;
	private int price;
	private int raNo;

	public Shop() {
	}

	public Shop(int no, String name, String kind, int price, int raNo) {
		super();
		this.no = no;
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.raNo = raNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getRaNo() {
		return raNo;
	}

	public void setRaNo(int raNo) {
		this.raNo = raNo;
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
}
