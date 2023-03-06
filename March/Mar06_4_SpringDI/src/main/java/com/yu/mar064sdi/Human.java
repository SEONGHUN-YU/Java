package com.yu.mar064sdi;

import java.util.ArrayList;
import java.util.HashMap;

public class Human {
	// 기본형급
	private String name;
	private int age;

	// has a 관계
	private Dog pet;

	// 컬렉션
	private String[] nickname;
	private ArrayList<String> friends;
	private HashMap<String, Double> stats;

	public Human() {
	}

	public Human(String name, int age, Dog pet, String[] nickname, ArrayList<String> friends,
			HashMap<String, Double> stats) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
		this.nickname = nickname;
		this.friends = friends;
		this.stats = stats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog getPet() {
		return pet;
	}

	public void setPet(Dog pet) {
		this.pet = pet;
	}

	public String[] getNickname() {
		return nickname;
	}

	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	public HashMap<String, Double> getStats() {
		return stats;
	}

	public void setStats(HashMap<String, Double> stats) {
		this.stats = stats;
	}
}
