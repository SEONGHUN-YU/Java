package com.yu.jan251uc.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// 일반배열 []
// List계열
// Set계열
// Map계열(다른 언어에서 dict라 부르는)
//		Map은 순서 개념이 X
//		키(기준) - 값
//		찾는 기준이랑, 찾았을 때 무슨 값이 나오는 지 내 마음대로 지정하는 애
public class UCMain4 {
	public static void main(String[] args) {
		// List + Map 필수 조합

		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("사과", 1000); // 얘는 추가할 때 put을 쓴다 add가 아님
		hm.put("귤", 500);
		hm.put("사과", 2000); // 같은 키를 또 쓰면 overwrite된다, add 개념이 없음
		System.out.println(hm.get("사과")); // 찾을 때 키를 넣으면 값이 나온다
		System.out.println("-----");

		Set<String> s = hm.keySet(); // <- 맵에서 키들만 추출할 때 쓰는 거
		// ↑ 그냥 쌩 Set을 써야 함
		ArrayList<String> al = new ArrayList<>(s);
		for (String k : al) {
			System.out.println(k); // 키
			System.out.println(hm.get(k)); // 값
		}
	}
}
