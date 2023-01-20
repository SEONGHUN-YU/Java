package com.yu.jan203uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.yu.jan203uc.subway.SubwayStationInfo;

// subway.csv
// 2015/01/01 ~ 2022/12/31 동안에
// 이용객수(타고+내린) 제일 많았던 날의 정보
// yyyy/MM/dd
// 몇호선
// 무슨역
// 탄사람
// 내린사람

// 1. subway.csv 읽어와서 콘솔출력
// 2. 객체로 만들기
// 3. ArrayList에 담아서
// 4. 정렬시키고
// 5. 정보빼내기
public class UCMain3 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			// 불러오기(파일읽기) 영역
			FileInputStream fis = new FileInputStream("D:\\yu\\subway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			ArrayList<SubwayStationInfo> sw = new ArrayList<>();
			String line = null;
			while ((line = br.readLine()) != null) {
				SubwayStationInfo ssi = new SubwayStationInfo(line);
				ssi.printInfo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
