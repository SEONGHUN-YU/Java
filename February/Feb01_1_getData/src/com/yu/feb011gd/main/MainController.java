package com.yu.feb011gd.main;

import java.util.ArrayList;

// 지저분할 수는 있지만
// MVC패턴이 조금 뭉개질 수도 있지
// 그래도 결과는 내야해 슬슬

// 실행할 때마다 서울시 실시간 미세먼지 데이터
// 저장하는 프로그램

public class MainController {
	public static void main(String[] args) {
		DustDAO_t.getDust();
		
//		ArrayList<DustDTO> al = DustDAO.getDust();
//		DustDAO.saveToDB(al);
	}
}
