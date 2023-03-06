package com.yu.mar064sdi;

import org.springframework.beans.factory.annotation.Autowired;

// 1) 세상의 모든 게장은 beans3.xml에 있는 그 사람이 만든다
// 2) beans3.xml에는 사람 하나 등록되어 있음
// 3) aac방식 : 딱히 사용하지 않아도 사람은  생성될 것
public class Gejang {
	@Autowired
	private Human producer;

	public Human getProducer() {
		return producer;
	}
}
