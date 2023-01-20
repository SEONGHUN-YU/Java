package com.yu.jan203uc.main;

import java.util.ArrayList;
import java.util.Comparator;

//	배열 []
//			만들 때 사이즈 고정
//				만들 때 사이즈 모르면?
//				추가를 못함...
//			자료형 섞기 불가능
// Collection <- 객체만 담을 수 있음
//	List계열 : 배열의 상위호환 
//	Set계열 : 중복데이터를 자동으로 제거해줌, 다만 순서가 랜덤?, 제어하기가 힘듬
//	Map계열(Python dict) : 순서 개념이 없고, 키-값을 받는 형태 (사전같은 느낌)

public class UCMain {
	public static void main(String[] args) {
		// List - ArrayList, Vector, ... (인터페이스?)
		// Hero - Ironman, Hulk, ... 같은 느낌
		// ArrayList가 가장 평범한 애임
		// Vector : List + multi-thread에 안전한 장치 넣음

		ArrayList al = new ArrayList(); // 만들 때 사이즈 필요없음
		al.add(13); // 언제든지 추가할 수 있음
		al.add(454);
		al.add("ㅋ"); // 자료형도 섞을 수 있다 <- 근데 이게 의외로 쓰기 불편하고 굳이 할 이유가 없는데?
		al.add(234.123);

		System.out.println(al.size()); // 배열은 .length, List는 .size()
		System.out.println(al.get(2)); // 배열은 al[2], List는 .get(2)
		System.out.println("-----");

		// <기본형의 객체형)> : generic
		// 특정 객체형으로 강제시켜 버리는 것
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(new Integer(23)); // 원래 문법
		al2.add(343); // <- 이렇게 써도 괜찮음 autuboxing 때문에 (int -> Integer자동변환)
//		al2.add("ㅋ"); <- generic 때문에 에러남
		al2.add(23);
		al2.add(4564);
		al2.add(122); // add로 추가시키는 기능!
		al2.add(1, 9999); // 1번 위치에 9999를 추가시키고, 나머지는 한칸씩 뒤로 민다
		al2.set(0, 1111); // 0번을 1111로 바꾸기
		al2.remove(3); // 3번 데이터 삭제

		// List를 정렬하고 싶을 때
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
//						o1.compareTo(o2); // 오름차순
				return o2.compareTo(o1); // 내림차순
			}
		};
		al2.sort(c);

		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		System.out.println("-----");

		for (Integer j : al2) { // foreach문도 된다
			System.out.println(j);
		}

	}
}
