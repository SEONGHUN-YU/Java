package com.yu.feb012ad.main;

public class LocationCount {
	private String Location;
	private double count;

	public LocationCount() {
	}

	public LocationCount(String location, double count) {
		super();
		Location = location;
		this.count = count;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}

}
