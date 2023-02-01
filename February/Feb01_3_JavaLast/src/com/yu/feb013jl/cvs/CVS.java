package com.yu.feb013jl.cvs;

public class CVS {
	private int no;
	private String name;
	private String location;
	private String addr;

	public CVS() {
	}

	public CVS(int no, String name, String location, String addr) {
		super();
		this.no = no;
		this.name = name;
		this.location = location;
		this.addr = addr;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}