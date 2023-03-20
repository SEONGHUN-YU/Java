package com.yu.mar201ajax.product;

import java.util.List;

public class Products {
	private List<Product> product; // JSON 때는 복수형 네이밍해도 상관 없음
	
	public Products() {
	}

	public Products(List<Product> product) {
		super();
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
