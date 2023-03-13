package com.yu.bpbascp.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal bsr_no;
	private BigDecimal bsr_bs_no;
	private String bsr_writer;
	private String bsr_txt;
	private Date bsr_date;

	private BigDecimal bs_no;
	private String bm_id;

	public SNSReply() {
	}

	public SNSReply(BigDecimal bsr_no, BigDecimal bsr_bs_no, String bsr_writer, String bsr_txt, Date bsr_date,
			BigDecimal bs_no, String bm_id) {
		super();
		this.bsr_no = bsr_no;
		this.bsr_bs_no = bsr_bs_no;
		this.bsr_writer = bsr_writer;
		this.bsr_txt = bsr_txt;
		this.bsr_date = bsr_date;
		this.bs_no = bs_no;
		this.bm_id = bm_id;
	}

	public BigDecimal getBsr_no() {
		return bsr_no;
	}

	public void setBsr_no(BigDecimal bsr_no) {
		this.bsr_no = bsr_no;
	}

	public BigDecimal getBsr_bs_no() {
		return bsr_bs_no;
	}

	public void setBsr_bs_no(BigDecimal bsr_bs_no) {
		this.bsr_bs_no = bsr_bs_no;
	}

	public String getBsr_writer() {
		return bsr_writer;
	}

	public void setBsr_writer(String bsr_writer) {
		this.bsr_writer = bsr_writer;
	}

	public String getBsr_txt() {
		return bsr_txt;
	}

	public void setBsr_txt(String bsr_txt) {
		this.bsr_txt = bsr_txt;
	}

	public Date getBsr_date() {
		return bsr_date;
	}

	public void setBsr_date(Date bsr_date) {
		this.bsr_date = bsr_date;
	}

	public BigDecimal getBs_no() {
		return bs_no;
	}

	public void setBs_no(BigDecimal bs_no) {
		this.bs_no = bs_no;
	}

	public String getBm_id() {
		return bm_id;
	}

	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}
}
