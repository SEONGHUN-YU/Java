package RockPaper;

import java.util.Scanner;

// 조건문
// 반복문
// 배열
// 그 언어만의 특징 -> 그럼 Java의 특징은 뭔데?
// 을 가지고 놀 수 있으면 그 언어를 마스터 했다고 할 수 있다

// 남이 작업한 거 잘 쓰기
// 자기가 작업한 거 공유하는 16:41;

// 작업 끝 -> 공유, 소스는 말고
// jar파일로 export -> 공유
// .jar
//		Java ARchive
//		컴파일된(기계어로 바뀐)거 압축

// Java : 전세계적으로 메이져한 언어
// Java - android, JSP, Spring, ...
// obj-c/swift : 마이너

// android앱 : Java로 만들어진 개발킷

// ios앱 : objective-c로 만들어진 개발킷

// 설명서 만들기
//	Project -> Generate Javadoc

/**
 * 어쩌고 저쩌고
 * 
 * @author sdedu
 * 
 */
public class User {
	Scanner brain = new Scanner(System.in);
	int win;

	/**
	 * 메소드 사용법 어쩌고 저쩌고
	 * 
	 * @return 가위바위보 뭐 낸거
	 */
	public int fire() {
		return brain.nextInt();
	}
}
