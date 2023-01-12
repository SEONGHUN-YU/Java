package com.yu.jan121oop.product;

public class Book extends Product {
	private String author;

	public Book() {
		// private는 상속이 안 되는구나 - 엄밀히 따지면 X
		// private 판정 기준이 Product쪽에 있고
		// Book은 Product 외부니까 라는 관점인 것 같다
//		System.out.println(name); // ?
		System.out.println(getName());
	}

	public Book(String name, int price, String author) {
		super(name, price);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public void showinfo() {
		super.showinfo();
		System.out.println(author);
	}

}
