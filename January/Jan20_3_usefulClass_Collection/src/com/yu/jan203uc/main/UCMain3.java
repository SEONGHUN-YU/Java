package com.yu.jan203uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

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

// 운행정보 통계를 내려면
// 운행정보들이 다 저장돼 있어야 되는데
// 들 : 배열
public class UCMain3 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			// 불러오기(파일읽기) 영역
			FileInputStream fis = new FileInputStream("D:\\yu\\subway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			// 데이터가 정확히 몇개인지 모름 -> 배열 못 씀
			// 정확한 사이즈를 몰라도 되는 ArrayList

			ArrayList<SubwayStationInfo> ssis = new ArrayList<>();

			String line = null;
			while ((line = br.readLine()) != null) {
				// 데이터 한줄 -> SSI객체로 -> ArrayList에 추가
				ssis.add(new SubwayStationInfo(line));
			}
			// while문이 끝난 시점에 운행정보들이 ArrayList로 완성되어있는 상태
			System.out.println("=====");
			System.out.println(ssis.size()); // 총 데이터 수

			System.out.println("-----");
			// 제대로 찍고 내리고 있는지 아니면 무임승차 있는지
			long get_on_sum = 0;
			long get_off_sum = 0;
			for (SubwayStationInfo ssi : ssis) {
				get_on_sum += ssi.getGet_on();
				get_off_sum += ssi.getGet_off();
			}
			System.out.println(get_on_sum);
			System.out.println(get_off_sum);
			System.out.println("-----");

			// 이용객수가 가장 많았던 날을 알고싶다 -> 정렬활용
			ssis.sort(new Comparator<SubwayStationInfo>() {
				@Override
				public int compare(SubwayStationInfo o1, SubwayStationInfo o2) {
					Integer o1sum = o1.getGet_on() + o1.getGet_off();
					Integer o2sum = o2.getGet_on() + o2.getGet_off();
					return o2sum.compareTo(o1sum);
				}
			});
			ssis.get(0).printInfo();
			System.out.println("-----");

			// ↓ 이용객수가 가장 적었던 날
			ssis.get(ssis.size() - 1).printInfo();

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
