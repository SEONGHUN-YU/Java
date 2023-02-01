package com.yu.feb012ad.main;

import java.util.ArrayList;

// 정상적으로 기록된 거만 조회(select)
// location별 평균(fine+ultra)
// 더러운 순으로
public class MainController {
	public static void main(String[] args) {
		ArrayList<LocationCount> alc = DustDAO.getCount();
		Console.print(alc);
	}
}
