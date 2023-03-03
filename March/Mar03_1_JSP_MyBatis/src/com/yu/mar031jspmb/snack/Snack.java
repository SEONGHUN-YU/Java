package com.yu.mar031jspmb.snack;

import java.math.BigDecimal;
import java.util.Date;

// 1. DB필드명/멤버변수명 같게
// 2. OracleDB만 해당되는 DB의 number때문에 BigDecimal로
// 3. 생성자/getter/setter 챙기고
// 4. Date다룰 때는 java.util.Date만
public class Snack {
	private BigDecimal s_no;
	private String s_name;
	private BigDecimal s_price;
	private Date s_exp;

	public Snack() {
	}

	public Snack(BigDecimal s_no, String s_name, BigDecimal s_price, Date s_exp) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_price = s_price;
		this.s_exp = s_exp;
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public BigDecimal getS_price() {
		return s_price;
	}

	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}

	public Date getS_exp() {
		return s_exp;
	}

	public void setS_exp(Date s_exp) {
		this.s_exp = s_exp;
	}
}
