package com.yu.mar141.macro;

import java.math.BigDecimal;

public class Macro {
	private BigDecimal bm_no;
	private String bm_comment;

	public Macro() {
	}

	public Macro(BigDecimal bm_no, String bm_comment) {
		super();
		this.bm_no = bm_no;
		this.bm_comment = bm_comment;
	}

	public BigDecimal getBm_no() {
		return bm_no;
	}

	public void setBm_no(BigDecimal bm_no) {
		this.bm_no = bm_no;
	}

	public String getBm_comment() {
		return bm_comment;
	}

	public void setBm_comment(String bm_comment) {
		this.bm_comment = bm_comment;
	}
}
