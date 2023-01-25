package com.yu.jan251uc.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

// 로또번호 자동 생성기
// 1 ~ 45 랜덤한 숫자
// 중복없이
// 오름차순 정렬
public class UCMain3 {
	public static void main(String[] args) {
		Random r = new Random();
		HashSet<Integer> hs = new HashSet<>();
		while (hs.size() < 6) { // while (true)에 if (hs.size() == 6) break;로 해도 됨
			hs.add(r.nextInt(45) + 1);
		}

		ArrayList<Integer> al = new ArrayList<>(hs);
		al.sort(new Comparator<Integer>() { // al.sort((o1, o2) -> (o1 - o2)); (아멘's knowledge)
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});

		for (Integer i : al) { // .sort 해준 값을 넣는다
			System.out.println(i);
		}

	}
}
