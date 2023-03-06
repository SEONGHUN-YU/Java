package com.yu.mar064sdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// beans3.xml에 개 하나 등록 (마음대로), 사람 하나 등록(생성자로), aac방식으로
public class SDIMain5 {
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans3.xml");
		aac.registerShutdownHook();

		Gejang g = aac.getBean("g", Gejang.class);
		System.out.println(g.getProducer().getName());
		System.out.println(g.getProducer().getAge());

		Dog d = aac.getBean("d", Dog.class);
		System.out.println(String.format("%s\r\n%d", d.getName(), d.getAge()));
		System.out.println("-----");
		Human h = aac.getBean("h", Human.class);
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.getPet().getName());
		System.out.println(h.getNickname()[0]);
		System.out.println(h.getFriends());
		System.out.println(h.getStats().get("키"));
		aac.close();
	}
}
