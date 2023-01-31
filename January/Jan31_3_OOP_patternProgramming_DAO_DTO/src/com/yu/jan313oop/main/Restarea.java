package com.yu.jan313oop.main;

public class Restarea {
	// 멤버변수, attribute, field
	private int no;
	private String name;
	private String toward;
	private String area;
	private int parking;

	public Restarea() {
	}

	public Restarea(int no, String name, String toward, String area, int parking) {
		super();
		this.no = no;
		this.name = name;
		this.toward = toward;
		this.area = area;
		this.parking = parking;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToward() {
		return toward;
	}

	public void setToward(String toward) {
		this.toward = toward;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getParking() {
		return parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

}
