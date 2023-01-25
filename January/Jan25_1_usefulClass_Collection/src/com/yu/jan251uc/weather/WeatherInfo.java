package com.yu.jan251uc.weather;

// 오름차순 : 가나다순
// "-10.0"
// "-3.0"

// 오름차순 : 작은 숫자를 앞으로 보냄
// -1.0
// -3.0

public class WeatherInfo {
	private String date;
	private String hour;
	private String wfKor;
	private double temp; // 따라서 이 경우는 double로

	public WeatherInfo() {
	}

	public WeatherInfo(String date, String hour, String wfKor, double temp) {
		super();
		this.date = date;
		this.hour = hour;
		this.wfKor = wfKor;
		this.temp = temp;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
		if (date.equals("0")) {
			this.date = "오늘";
		} else if (date.equals("1")) {
			this.date = "내일";
		} else if (date.equals("2")) {
			this.date = "모레";
		}
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double string) {
		this.temp = string;
	}

	public void printInfo() {
		System.out.printf("%s %s시 %s %.1f도\n", date, hour, wfKor, temp);
	}
}
