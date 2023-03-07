package com.yu.mar072smvc.uc;

public class UCBean {
	private double num;
	private String what;
	private String from;
	private double result;
	private String to;

	public UCBean() {
	}

	public UCBean(double num, String what, String from, double result, String to) {
		super();
		this.num = num;
		this.what = what;
		this.from = from;
		this.result = result;
		this.to = to;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
