package com.yu.jan203uc.subway;

import java.util.Date;

public class SubwayStationInfo {
	private Date date;
	private String subwayline;
	private String stationName;
	private int get_on;
	private int get_off;

	public SubwayStationInfo() {
	}

	public SubwayStationInfo(String subwayline) {
		String[] line2 = subwayline.split(",");
		subwayline = line2[3];
		stationName = line2[4];
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubwayline() {
		return subwayline;
	}

	public void setSubwayline(String subwayline) {
		this.subwayline = subwayline;
	}

	public String getStation() {
		return stationName;
	}

	public void setStation(String station) {
		this.stationName = station;
	}

	public int getGet_on() {
		return get_on;
	}

	public void setGet_on(int get_on) {
		this.get_on = get_on;
	}

	public int getGet_off() {
		return get_off;
	}

	public void setGet_off(int get_off) {
		this.get_off = get_off;
	}

	public void printInfo() {
		System.out.println(date);
		System.out.println(subwayline);
		System.out.println(stationName);
		System.out.println(get_on);
		System.out.println(get_off);
	}
}
