package com.yu.feb013jl.snack;

public class CVS_Snack {
	private String c_name;
	private String c_location;
	private String s_name;
	private int s_price;

	public CVS_Snack() {
	}

	public CVS_Snack(String c_name, String c_location, String s_name, int s_price) {
		super();
		this.c_name = c_name;
		this.c_location = c_location;
		this.s_name = s_name;
		this.s_price = s_price;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_location() {
		return c_location;
	}

	public void setC_location(String c_location) {
		this.c_location = c_location;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

}
