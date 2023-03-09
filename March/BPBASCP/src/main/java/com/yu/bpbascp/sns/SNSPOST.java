package com.yu.bpbascp.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSPOST { // DTO
	private BigDecimal bs_no;
	private String bs_writer;
	private String bs_txt;
	private Date bs_date;

	public SNSPOST() {
	}

	public SNSPOST(BigDecimal bs_no, String bs_writer, String bs_txt, Date bs_date) {
		super();
		this.bs_no = bs_no;
		this.bs_writer = bs_writer;
		this.bs_txt = bs_txt;
		this.bs_date = bs_date;
	}

	public BigDecimal getBs_no() {
		return bs_no;
	}

	public void setBs_no(BigDecimal bs_no) {
		this.bs_no = bs_no;
	}

	public String getBs_writer() {
		return bs_writer;
	}

	public void setBs_writer(String bs_writer) {
		this.bs_writer = bs_writer;
	}

	public String getBs_txt() {
		return bs_txt;
	}

	public void setBs_txt(String bs_txt) {
		this.bs_txt = bs_txt;
	}

	public Date getBs_date() {
		return bs_date;
	}

	public void setBs_date(Date bs_date) {
		this.bs_date = bs_date;
	}
}
