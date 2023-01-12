package com.yu.jan122oop.main;

import java.util.Calendar;

import com.yu.jan122oop.Me.YU;

public class OOPMain {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		// 무조건 클래스명 변수명 = new 생성자명 식으로 만드는 건 아니었다!
		YU yu = YU.getInstance();
		System.out.println(yu.getName());
	}

}
