package com.yu.bpbascp.member;

import java.util.Date;

public class Member {
	private String bm_id;
	private String bm_pw;
	private String bm_name;
	private Date bm_birthday;
	private String bm_address;
	private String bm_photo;

	public Member() {
	}

	public Member(String bm_id, String bm_pw, String bm_name, Date bm_birthday, String bm_address, String bm_photo) {
		super();
		this.bm_id = bm_id;
		this.bm_pw = bm_pw;
		this.bm_name = bm_name;
		this.bm_birthday = bm_birthday;
		this.bm_address = bm_address;
		this.bm_photo = bm_photo;
	}

	public String getBm_id() {
		return bm_id;
	}

	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}

	public String getBm_pw() {
		return bm_pw;
	}

	public void setBm_pw(String bm_pw) {
		this.bm_pw = bm_pw;
	}

	public String getBm_name() {
		return bm_name;
	}

	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	}

	public Date getBm_birthday() {
		return bm_birthday;
	}

	public void setBm_birthday(Date bm_birthday) {
		this.bm_birthday = bm_birthday;
	}

	public String getBm_address() {
		return bm_address;
	}

	public void setBm_address(String bm_address) {
		this.bm_address = bm_address;
	}

	public String getBm_photo() {
		return bm_photo;
	}

	public void setBm_photo(String bm_photo) {
		this.bm_photo = bm_photo;
	}
}
