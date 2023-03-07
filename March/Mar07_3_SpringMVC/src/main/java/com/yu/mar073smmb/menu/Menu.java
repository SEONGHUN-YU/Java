package com.yu.mar073smmb.menu;

import java.math.BigDecimal;

// MyBatis : select결과를 객체로 만들어줌
//		DB필드명과 멤버변수명 같게 해놓으면 MyBatis 해줌
//		(OracleDB한정) number -> BigDecimal
// SpringMVC : req parameter를 객체로 만들어 줌
//		req parameter명과 멤버변수명 같게 해놓으면 SpringMVC 해줌

// 어떡하면 둘의 효과를 다 받을 수 있을까? => 멤버변수명 통일해
public class Menu { // DTO
	private String m_name;
	private BigDecimal m_price;

	public Menu() {
	}

	public Menu(String m_name, BigDecimal m_price) {
		super();
		this.m_name = m_name;
		this.m_price = m_price;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public BigDecimal getM_price() {
		return m_price;
	}

	public void setM_price(BigDecimal m_price) {
		this.m_price = m_price;
	}
}
