package com.yu.jan131oop.human;

import com.yu.jan131oop.hero.Hero;

public class Human {
	private String name;
	private Hero hero;

	public Human() {
	}

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 이 세계관에서는 자기 전담영웅 찜하기 기능이 있다고 치자
	public void pick(Hero h) {
		hero = h;
	}
	
	// 도움요청하기 기능
	public void help() {
		System.out.println("살려주세요");
		hero.attack();
	}

}
