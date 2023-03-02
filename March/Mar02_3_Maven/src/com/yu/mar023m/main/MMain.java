package com.yu.mar023m.main;

// XML파싱 하고 싶음 -> Java에 그런기능 없음
// 전세계 개발자 중 누군가는 만들어뒀음, 공유까지 해놨음
// -> 오죽 많이쓰다보니 중앙제어시스템(Maven)까지 생겼다
// Java개발자는 그런 거 잘 갖다쓰는 능력이 중요
// => kxml.jar를 써봅시다

//.jar파일
//		인터넷에서 다운 받아서
//			쌩 Java프로젝트 : Build Path...
//			웹 프로젝트 : WEB-INF/lib에...
//		=> 수동으로 관리

// Maven : 편한데, 수업시간에 kxml -> 20명이 동시에 -> ddos(?) 다운받다가 터짐

// Maven : .jar 자동관리 시스템
//		메이븐 중앙저장소 : https://mvnrepository.com/
//		pom.xml의 <dependencies></dependencies>속에 소스 붙이면
//		중앙저장소에서 자동으로 다운 받아와서 프로젝트에 세팅해줌
//		이 컴의 로컬저장소에 저장하고 (C:\사용자\계정\.m2\repository)에 저장하고 있음
//		프로젝트에 세팅해줌
public class MMain {
	public static void main(String[] args) {

	}
}
