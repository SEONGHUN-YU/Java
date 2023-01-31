package com.yu.jan313oop.main;

// insert into
// 휴게소 이름 :
// 방향 :
// 위치 :
// 주차 대수 :

// C
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		try {
			Restarea ra = cs.getRestarea();
			String result = RestareaDAO.reg(ra);
			cs.print(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cs.kill();
	}
}
