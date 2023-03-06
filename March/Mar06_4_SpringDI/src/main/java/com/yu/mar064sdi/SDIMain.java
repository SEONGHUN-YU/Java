package com.yu.mar064sdi;

public class SDIMain {
	public static void main(String[] args) {
		Dog a = new Dog("뽀삐", 1);
		System.out.println(a.getName());
		System.out.println(a.getAge());
		System.out.println("-----");
		Dog b = new Dog();
		b.setName("뿌삐");
		b.setAge(2);
		System.out.println(String.format("이름 : %s\r\n나이 : %d", b.getName(), b.getAge()));
	}
}
