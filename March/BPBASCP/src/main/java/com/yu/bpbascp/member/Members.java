package com.yu.bpbascp.member;

import java.util.ArrayList;

public class Members {
	private ArrayList<Member> member; // 단수형 네이밍

	public Members() {
	}

	public Members(ArrayList<Member> member) {
		super();
		this.member = member;
	}

	public ArrayList<Member> getMember() {
		return member;
	}

	public void setMember(ArrayList<Member> member) {
		this.member = member;
	}
}
