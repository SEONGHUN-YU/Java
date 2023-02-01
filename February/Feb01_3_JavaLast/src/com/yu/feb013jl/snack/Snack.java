package com.yu.feb013jl.snack;

import java.util.Date;

public class Snack {
	private int no;
	private String name;
	private int price;
	private Date exp;
	private int cvsno;
	private String exp_pre;

	public Snack() {
	}

	public Snack(int no, String name, int price, Date exp, int cvsno) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.exp = exp;
		this.cvsno = cvsno;

	}

	public Snack(int no, String name, int price, int cvsno, String exp_pre) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.cvsno = cvsno;
		this.exp_pre = exp_pre;
	}

	public String getExp_pre() {
		return exp_pre;
	}

	public void setExp_pre(String exp_pre) {
		this.exp_pre = exp_pre;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public int getCvsno() {
		return cvsno;
	}

	public void setCvsno(int cvsno) {
		this.cvsno = cvsno;
	}
}
