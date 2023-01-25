package com.yu.jan203uc.subway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubwayStationInfo {
	private Date date;
	private String subwayline;
	private String stationName;
	private int get_on;
	private int get_off;

//	생성자, 오버로딩생성자, 게터세터, info

	public SubwayStationInfo() {
	}

	public SubwayStationInfo(String subwayline) throws ParseException {
		String[] line2 = subwayline.split(",");
//		line2[0] = "2010";
//		line2[1] = "01";
//		line2[2] = "01";
		String date2 = line2[0] + line2[1] + line2[2]; // 20100101"
		date = new SimpleDateFormat("yyyyMMdd").parse(date2);
		this.subwayline = line2[3];
		stationName = line2[4];
		// ↓ "20101" -> int로
		get_on = Integer.parseInt(line2[5]); // String -> Interger -> int
		get_off = Integer.parseInt(line2[6]);
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
		System.out.println(new SimpleDateFormat("yyyy/MM/dd(E)").format(date));
		System.out.println(subwayline + " - " + stationName);
		System.out.println("탄 사람 : " + get_on);
		System.out.println("내린 사람 : " + get_off);
		System.out.println("-----");
	}
}
