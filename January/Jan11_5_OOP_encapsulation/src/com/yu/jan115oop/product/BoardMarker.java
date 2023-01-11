package com.yu.jan115oop.product;

// 객체지향하는 이유
//		정보은닉 -> 최대한 감추는 쪽으로 하길 바람
// 제품명은 수정할 일이 없다
// 색깔은 수정해야하지 싶다
public class BoardMarker {
	// 1. 멤버변수 배치
	private String name;
	private String color;

	// 2. 생성자시리즈
	// 2-1 기본생성자(ctrl + space)
	public BoardMarker() {
	}

	// 2-2 오버로딩된 생성자(쌤은 ctrl + shift + a)
	public BoardMarker(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	// 3. getter, setter(ctrl + shift + s)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// method : 일반적으론 외부에서 쓰려고 public으로 풀어줌, 필요할 때는 잠궈버림
	// 4. 그 외 기타 method
	public void print() {
		System.out.println(name);
		System.out.println(color);
	}
}
