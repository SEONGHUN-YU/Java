package com.yu.feb011gd.main;

import java.util.Date;

public class DustDTO {
	private Date date;
	private String area;
	private String location;
	private double fine;
	private double ultra;
	private String condition;

	public DustDTO() {
	}

	public DustDTO(Date date, String area, String location, double fine, double ultra, String condition) {
		super();
		this.date = date;
		this.area = area;
		this.location = location;
		this.fine = fine;
		this.ultra = ultra;
		this.condition = condition;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public double getUltra() {
		return ultra;
	}

	public void setUltra(double ultra) {
		this.ultra = ultra;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String d = "null";
		try {
			d = date.toString();
		} catch (Exception e) {
		}
		String a = "null";
		try {
			a = area;
		} catch (Exception e) {
		}
		String l = "null";
		try {
			l = location;
		} catch (Exception e) {
		}
		double f = 0;
		try {
			f = fine;
		} catch (Exception e) {
		}
		double u = 0;
		try {
			u = ultra;
		} catch (Exception e) {
		}
		String c = "null";
		try {
			c = condition;
		} catch (Exception e) {
		}
		return String.format("<%s-%s-%s-%.0f-%.0f-%s>", d, a, l, f, u, c);
	}
}
