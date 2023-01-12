package com.yu.jan121oop.product;

public class Food extends Product {
	private String expire;

	public Food() {
	}

	public Food(String name, int price, String expire) {
		super(name, price);
		this.expire = expire;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}
	
	@Override
	public void showinfo() {
		super.showinfo();
		System.out.println(expire);
	}
}
