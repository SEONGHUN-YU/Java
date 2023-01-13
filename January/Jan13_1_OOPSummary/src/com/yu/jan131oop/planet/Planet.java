package com.yu.jan131oop.planet;

import com.yu.jan131oop.human.Human;

public class Planet {
	private String name;
	private int size;
	private boolean visible;
	private Human human;

	public Planet() {
	}

	// 쌤의 요구
	public Planet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	// 입주등록하기
	public void add(Human h) {
		human = h;
		System.out.println(name + "에");
		System.out.println(human.getName() + "이 등록");

	}

}
