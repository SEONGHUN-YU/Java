package com.yu.mar062m.main;

// 리더급 개발자 입장이 되어
// 개발자A : 지하철 작업 지시
// 개발자B : 버스 작업 지시

// 회사에서 방침이 default를 버스 타는 거로 바꿔라하면?
// => 소스 부분만 바꾸고 => 컴파일 => 압축 => ...
public class MMain {
	public static void main(String[] args) {
		Vehicle v = new Subway();
		v.go();
	}
}
