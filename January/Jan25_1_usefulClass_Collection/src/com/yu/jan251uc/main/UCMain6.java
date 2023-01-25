package com.yu.jan251uc.main;

import java.util.HashMap;
import java.util.Scanner;

import com.yu.jan251uc.student.Student;

// [], List, Set, Map -> 지금은 Map 써야할 때!

// [] : 안습
// List : 순서 개념으로 데이터 접근, 통계내고 -> 주력
// Set : 기본형급 중복 없앨 때 (객체도 가능은 함)
// Map : 순서가 아닌걸로 데이터 접근 -> 검색쪽에 힘을 줘야할 때

public class UCMain6 {
	public static void main(String[] args) {
		// 학생들
		HashMap<String, Student> students = new HashMap<>();
		students.put("홍길동", new Student("홍길동", 100, 20, 3));
		students.put("김길동", new Student("김길동", 10, 2, 33));
		students.put("이길동", new Student("이길동", 1, 20, 89));

		Scanner k = new Scanner(System.in);
		System.out.println("이름 : ");
		String s = k.next();

		// 그 이름에 해당하는 학생 정보 출력
		students.get(s).showInfo();

	}
}
