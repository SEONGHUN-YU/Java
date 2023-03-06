package com.yu.mar063m;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

// EJB(Enterprise JavaBean) : winter

// Spring : POJO(Plain Old Java Object)
//		EJB때처럼 JavaBean에 뭔 설정넣고 그런 거 없이 그냥 POJO를 써서
//		IoC로 DI해주는 Framework

//		Ioc(Inversion of Control) : 제어의 역전
//			프로그램 -제어-> 파일 : 매우 자연스러움
//			파일 -제어-> 프로그램 : 이런 형태가 IoC

//		DI(Dependency Injection) : 의존성 주입
//			객체 만들고, 값 넣고
public class MMain {
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader xbdr = new XmlBeanDefinitionReader(dlbf);
		xbdr.loadBeanDefinitions(new ClassPathResource("aaaa.xml"));

		// Vehicle vvv = (Vehicle) dlbf.getBean("v"); ↓ 이거랑 똑같은 거
		Vehicle vvv = dlbf.getBean("v", Vehicle.class);
		vvv.go();
	}
}
