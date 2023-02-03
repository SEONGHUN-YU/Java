package com.yu.feb013jl.snack;

import java.util.Date;

// library : 누군가가 작업해놔서, 그 사람이 시키는대로 하면 그 기능을 쓸 수 있는 거
// framework : library + 툴

// Spring_framework 가면 DB필드명과 멤버변수명을 맞춰야 된다고 함

// DTO : 테이블 하나 보고 만드는 거 X
// 최종적으로 join까지 다 고려해서 만듬
public class Snack {
	private int no;
	private String name;
	private int price;
	private Date exp; // 개발자용
	private int cvsno;
	private String exp_pre; // 디자이너용
	// join시킬거 고려해서 애초에 이걸 넣어놓든지
	// private String cvsName; <-
	// private String cvsJijum; <-
	
	// CVS_Snack.java 를 새로 만들어서 쓰든지 선택
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
