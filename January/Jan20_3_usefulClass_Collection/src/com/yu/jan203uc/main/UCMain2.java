package com.yu.jan203uc.main;

import java.util.ArrayList;
import java.util.Comparator;

import com.yu.jan203uc.student.Student;

// ArrayList 활용법
public class UCMain2 {
	public static void main(String[] args) {
		// 홍길동, 100, 90, 80 학생
		Student s = new Student("홍길동", 100, 90, 80);

		ArrayList<Student> students = new ArrayList<>();
		students.add(s); // 학생을 담을 수 있다
		students.add(new Student("김길동", 30, 20, 10));
		students.add(new Student("이길동", 10, 78, 45));
		students.add(new Student("박길동", 99, 88, 77));

		// 두번째 학생의 수학점수가 알고 싶다면?
		System.out.println(students.get(1).getMat());
		System.out.println("-----");

		// 첫번째 학생의 전체정보
		students.get(0).printInfo();
		System.out.println("=====");

		// 이름순 정렬
		Comparator<Student> c = new Comparator<Student>() { // generic을 같게 해준다
			@Override
			public int compare(Student o1, Student o2) {
				String o1Name = o1.getName();
				String o2Name = o2.getName();
				return o1Name.compareTo(o2Name); // 정배열
				// return o2Name.compareTo(o1Name); // 역배열
			}
		};
		students.sort(c);

		// 전 학생의 전체정보
		for (Student student : students) {
			student.printInfo();
			System.out.println("-----");
		}
		System.out.println("-----");

		// 1등학생 전체정보
		Comparator<Student> c2 = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				Integer o1Sum = o1.getKor() + o1.getEng() + o1.getMat();
				Integer o2Sum = o2.getKor() + o2.getEng() + o2.getMat();
				return o2Sum.compareTo(o1Sum);
			}
		};
		students.sort(c2);
		students.get(0).printInfo();

	}
}
