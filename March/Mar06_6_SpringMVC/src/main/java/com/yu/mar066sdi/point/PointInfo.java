package com.yu.mar066sdi.point;

public class PointInfo {
	private String name;
	private int money;
	private double point;

	public PointInfo() {
	}

	public PointInfo(String name, int money, double point) {
		super();
		this.name = name;
		this.money = money;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}
}
