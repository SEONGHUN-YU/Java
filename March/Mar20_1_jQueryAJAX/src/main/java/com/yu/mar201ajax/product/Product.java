package com.yu.mar201ajax.product;

import java.math.BigDecimal;

public class Product {
	private String p_name;
	private BigDecimal p_price;
	
	public Product() {
	}

	public Product(String p_name, BigDecimal p_price) {
		super();
		this.p_name = p_name;
		this.p_price = p_price;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}
}
