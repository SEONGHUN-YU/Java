package com.yu.jan251uc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

import com.yu.jan251uc.weather.WeatherInfo;

// [] : 안 씀
// List계열 : 가변사이즈 배열
// Set계열 : 중복제거, 다만 순서가 지멋대로다 <- Hash의 특징 ex)HashMap
//		기본형급 : 중복제거 시켜줌
//		객체 : 같은 객체 여러번 add하는 것 방지하는 수준밖에 안 됨
public class UCMain2 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(231);
		hs.add(12);
		hs.add(12);
		hs.add(564);
		hs.add(12);
		hs.add(12);
		System.out.println(hs.size());
		// Set은 바로 꺼내서 쓸 수는 없고 밑에 처럼 변환해주어야 한다
		// Set -> []
		// Set -> List

		// Collection간의 변환 : 생성자쓰면 된다
		ArrayList<Integer> al = new ArrayList<>(hs);
		for (Integer i : al) {
			System.out.println(i);
		}
		System.out.println("-----");

		// Java러의 주력은 List(중복값 포함할 수 있는 애)
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("ㅋ");
		al2.add("ㅎ");
		al2.add("ㅋ");
		al2.add("ㅇㅇ");
		al2.add("ㅡㅡ");
		al2.add("ㅋ");

		// Set으로 바꾸면 중복제거됨
		HashSet<String> hs2 = new HashSet<>(al2);
		al2 = new ArrayList<>(hs2);
		al2.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String s : al2) {
			System.out.println(s);
		}
		System.out.println("-----");

		WeatherInfo w = new WeatherInfo("몰라", "12", "비", 0);

		HashSet<WeatherInfo> wis = new HashSet<>();
		wis.add(w);
		wis.add(w);
		wis.add(w);
		wis.add(new WeatherInfo("몰라", "3", "맑음", 0));
		wis.add(new WeatherInfo("몰라", "6", "눈", -3)); // new는 새로운 주소
		wis.add(new WeatherInfo("몰라", "6", "눈", -3));
		wis.add(new WeatherInfo("몰라", "6", "눈", -3));
		wis.add(new WeatherInfo("몰라", "6", "눈", -3));
		System.out.println(wis.size()); // 이 때는 주소값에 따라 중복을 제거한다, 값이 같다고 똑같은 데이터가 아니다

	}
}
