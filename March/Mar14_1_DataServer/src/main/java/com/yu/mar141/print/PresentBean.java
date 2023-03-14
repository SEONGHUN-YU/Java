package com.yu.mar141.print;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// XML 응답하는 거 만드려면
//		테이블을 표현하는 JavaBean

// JavaBean : DB에 있는 데이터(매니저의 요구사항) 하나를 표현하기 위한 클래스
@XmlRootElement
public class PresentBean { // 데이터 하나를 표현하는 JavaBean
	private String mr_name;
	private BigDecimal mr_price;

	public PresentBean() {
	}

	public PresentBean(String mr_name, BigDecimal mr_price) {
		super();
		this.mr_name = mr_name;
		this.mr_price = mr_price;
	}

	public String getMr_name() {
		return mr_name;
	}
	
	@XmlElement
	public void setMr_name(String mr_name) {
		this.mr_name = mr_name;
	}

	public BigDecimal getMr_price() {
		return mr_price;
	}

	@XmlElement
	public void setMr_price(BigDecimal mr_price) {
		this.mr_price = mr_price;
	}
}
