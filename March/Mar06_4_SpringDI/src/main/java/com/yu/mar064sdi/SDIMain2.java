package com.yu.mar064sdi;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SDIMain2 {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("beans.xml"));
		System.out.println("-----");
		// beans.xml에 있는 거는 설계도 느낌이고 그 설계도대로 새로운 개를 생성하는 것 <- X 이거 아님, 주의
		// --------------------------------------------
		// beans.xml에 개를 만들어 놓고, 그 개 불러오기 <- O 이게 맞음
		// 처음 부를 때 객체를 만들기만 할 뿐, 여러번 불러도 같은 객체가 호출된다
		Dog d = dlbf.getBean("d", Dog.class);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		System.out.println(d);
		
		Dog d2 = dlbf.getBean("d",Dog.class);
		System.out.println(d2.getName());
		System.out.println(d2.getAge());
		System.out.println(d2);
	}
}
