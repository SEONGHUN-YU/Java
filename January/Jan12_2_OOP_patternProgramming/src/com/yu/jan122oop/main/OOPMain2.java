package com.yu.jan122oop.main;

import com.yu.jan122oop.soldesk.AN;
import com.yu.jan122oop.soldesk.Student;

public class OOPMain2 {
	public static void main(String[] args) {
		AN a = AN.getInstance();
		AN a2 = AN.getInstance();
		System.out.println(a);
		System.out.println(a2);
		System.out.println("-----");

		// 1.홍길동, 30, 양주 학생
		// 출력
//		Student h = new Student(1, "홍길동", 30, "양주");
		Student h = a.consult("홍길동", 30, "양주");
		h.showInfo();
		System.out.println("-----");

		// 2.김길동, 20, 포천 학생
		// 출력
//		Student k = new Student(2, "김길동", 20, "포천");
		Student k = a.consult("김길동", 20, "포천");
		k.showInfo();

	}

}
