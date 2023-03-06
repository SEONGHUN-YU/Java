package com.yu.mar064sdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// beans2.xml에 개 한마리 등록
public class SDIMain4 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans2.xml");
		aac.registerShutdownHook();
		System.out.println("-----");

		Dog d = aac.getBean("d", Dog.class);
		System.out.println(String.format("%s\r\n%d", d.getName(), d.getAge()));
		System.out.println("-----");

		Human h = aac.getBean("h", Human.class);
		System.out.println(String.format("%s\r\n%d", h.getName(), h.getAge()));
		System.out.println(String.format("%s\r\n%d", h.getPet().getName(), h.getPet().getAge()));
		System.out.println("-----");

		for (String n : h.getNickname()) {
			System.out.println(n);
		}
		for (String f : h.getFriends()) {
			System.out.println(f);
		}
		for (String s : h.getStats().keySet()) {
			System.out.println(h.getStats().get(s));
		}
		System.out.println("-----");
		aac.close();
	}
}
