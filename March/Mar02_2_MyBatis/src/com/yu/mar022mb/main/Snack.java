package com.yu.mar022mb.main;

import java.math.BigDecimal;

// MyBatis : DB ORM Framework
//		DB - DB
//		ORM - DB랑 POJO(DTO)랑 매핑해주는
//		Framework - 내부사정은 알 수가 없고, 대충 짐작만 가능
//					시키는대로 하면 자동으로 해주는
// JavaBean, DTO, VO(ValueObject), POJO(Plain Old Java Object)
public class Snack {
	// MyBatis 발동 조건
	// 1. DB필드명과 멤버변수명을 같게
	// 2. (OracleDB 한정 얘기인데) number : BigDecimal
	// OracleDB의 number라는 자료형은 정수/실수 다 되는 자료형인데
	// Java에서 정수/실수 동시에 소화할 수 있는 게 필요함 <- BigDecimal
	// 3. java.util.Date여야 함 (지금까지 계속 이렇게 써와서 사실 신경 안 써도 됨)
	// 4. getter/setter 당연히 해줘야겠지? DTO인데
	private String s_name;
	private BigDecimal s_price;

	public Snack() {
	}

	public Snack(String s_name, BigDecimal s_price) {
		super();
		this.s_name = s_name;
		this.s_price = s_price;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public BigDecimal getS_price() {
		return s_price;
	}

	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}
}
