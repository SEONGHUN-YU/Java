package com.yu.mar061m.main;

// 경로 추천 프로그램을 만드는 프로젝트

// 기본으로 지하철

// Main을 작업하는 리더급 개발자가, 작업한 것들을 받아서 여기에 작업할 것

// 리더급 개발자가 개발자A에게 method 형태에 대한 문제 제기를 할 수도
// 회사에서 방침이 default를 버스 타는 거로 바꿔라하면?
//		=> 소스 다 바꾸고 => 컴파일도 다시 => 압축도 다시 => 배포도 다시 해야할텐데... <- 이런 곳은 가면 안 됨...
public class MMain {
	public static void main(String[] args) {
		// Subway s = new Subway();
		// s.go();
		Bus b = new Bus();
		b.gogo();
	}
}
