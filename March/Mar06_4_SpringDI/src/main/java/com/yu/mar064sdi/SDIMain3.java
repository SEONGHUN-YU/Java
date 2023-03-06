package com.yu.mar064sdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain3 {
	// dlbf방식 : 객체를 처음 사용할 때 객체를 생성함
	// aac방식 : beans.xml 로드하는 순간에 등록된 객체들 다 만들어 놓음
	//			기존의 갈비지 컬렉션 얘기가 안 먹힘
	// 갈비지 컬렉션 : heap 영역 자동정리
	// 자동 발동시점 ? 언젠데
	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans.xml");
		
		aac.registerShutdownHook();
		// aac가 없어질 때, 만들어놨던 객체들도 같이 없어지게 하는 method
		System.out.println("-----");
		
		Dog d = aac.getBean("d", Dog.class);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		
		Dog dd2 = aac.getBean("d2", Dog.class);
		System.out.println(dd2.getName());
		System.out.println(dd2.getAge());
		
		aac.close(); // <- aac 없애기, 이 때 객체들도 같이 없어질 것
	}
}
