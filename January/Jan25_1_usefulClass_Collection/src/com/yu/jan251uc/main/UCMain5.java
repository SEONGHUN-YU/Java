package com.yu.jan251uc.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.yu.jan251uc.student.Student;

// [], List, Set, Map -> 지금은 List 써야할 때!
public class UCMain5 {
	public static void main(String[] args) {
		// 학생들
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 10, 20, 30));
		students.add(new Student("김길동", 100, 2, 3));
		students.add(new Student("이길동", 90, 80, 70));

		Scanner k = new Scanner(System.in);
		System.out.println("번호 : ");
		int n = k.nextInt();

		// 그 번호에 해당하는 학생 정보 출력 (출석부)
		students.get(n - 1).showInfo();
		System.out.println("-----");

		// 총 평균
		double avgSum = 0;
		for (Student s : students) { // 이 반복문 안에서는 변수(지금은 s)를 쓴다
			avgSum += ((s.getKor() + s.getEng() + s.getMat()) / 3.0); // 세 점수의 평균
		}
		System.out.println(avgSum / students.size()); // 학생 숫자로 나누는 것 (반 평균)
	}
}
