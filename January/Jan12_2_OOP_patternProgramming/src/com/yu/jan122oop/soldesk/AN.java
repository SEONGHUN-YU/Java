package com.yu.jan122oop.soldesk;

public class AN {
	private int studentcount;
	private String name;
	private String grade;
	private static final AN AN = new AN("안영광", "주임");

	private AN() {
	}

	private AN(String name, String grade) {
		super();
		this.name = name;
		this.grade = grade;
	}

	public static AN getInstance() {
		return AN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	// factory 패턴 과정
	// 3. 객체를 만들어낼 메소드
	// 4. 자동화 시키기 (밑에는 예시)
	public Student consult(String n, int a, String h) {
		studentcount++;
		return new Student(studentcount, n, a, h);

	}
}
