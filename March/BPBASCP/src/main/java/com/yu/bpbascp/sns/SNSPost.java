package com.yu.bpbascp.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

// JavaBean 만들 때 단순히 테이블 하나만 보고 만드는 게 아니고
// join시킬 것까지 고려해서 만들어야 한다
public class SNSPost { // DTO
	private BigDecimal bs_no;
	private String bs_writer;
	private String bs_txt;
	private Date bs_date;

	// join
	private String bm_id;
	private String bm_photo;

	// join하기도 subquery쓰기도 애매하니, Java에서 직접처리
	// 수동 join 느낌?
	private List<SNSReply> bs_replys;

	public SNSPost() {
	}

	public SNSPost(BigDecimal bs_no, String bs_writer, String bs_txt, Date bs_date, String bm_id, String bm_photo,
			List<SNSReply> bs_replys) {
		super();
		this.bs_no = bs_no;
		this.bs_writer = bs_writer;
		this.bs_txt = bs_txt;
		this.bs_date = bs_date;
		this.bm_id = bm_id;
		this.bm_photo = bm_photo;
		this.bs_replys = bs_replys;
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

	public String getBm_id() {
		return bm_id;
	}

	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}

	public String getBm_photo() {
		return bm_photo;
	}

	public void setBm_photo(String bm_photo) {
		this.bm_photo = bm_photo;
	}

	public List<SNSReply> getBs_replys() {
		return bs_replys;
	}

	public void setBs_replys(List<SNSReply> bs_replys) {
		this.bs_replys = bs_replys;
	}
}
