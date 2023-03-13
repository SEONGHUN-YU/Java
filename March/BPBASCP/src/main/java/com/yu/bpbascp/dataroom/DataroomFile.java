package com.yu.bpbascp.dataroom;

import java.math.BigDecimal;
import java.util.Date;

public class DataroomFile {
	private BigDecimal bd_no;
	private String bd_uploader;
	private String bd_title;
	private String bd_file;
	private Date bd_date;

	private String bm_photo;

	public DataroomFile() {
	}

	public DataroomFile(BigDecimal bd_no, String bd_uploader, String bd_title, String bd_file, Date bd_date,
			String bm_photo) {
		super();
		this.bd_no = bd_no;
		this.bd_uploader = bd_uploader;
		this.bd_title = bd_title;
		this.bd_file = bd_file;
		this.bd_date = bd_date;
		this.bm_photo = bm_photo;
	}

	public BigDecimal getBd_no() {
		return bd_no;
	}

	public void setBd_no(BigDecimal bd_no) {
		this.bd_no = bd_no;
	}

	public String getBd_uploader() {
		return bd_uploader;
	}

	public void setBd_uploader(String bd_uploader) {
		this.bd_uploader = bd_uploader;
	}

	public String getBd_title() {
		return bd_title;
	}

	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}

	public String getBd_file() {
		return bd_file;
	}

	public void setBd_file(String bd_file) {
		this.bd_file = bd_file;
	}

	public Date getBd_date() {
		return bd_date;
	}

	public void setBd_date(Date bd_date) {
		this.bd_date = bd_date;
	}

	public String getBm_photo() {
		return bm_photo;
	}

	public void setBm_photo(String bm_photo) {
		this.bm_photo = bm_photo;
	}
}
