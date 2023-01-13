package com.yu.jan135uc.main;

// 학생입장 : 이제야 쓸만한 거를 배우네, 잘 배워놨다가 써먹어야지

//			수업이 이제야 시작되는 느낌

// 문자열 객체(Class라는 거겠지?)
public class UCMain {
	public static void main(String[] args) {
//		String s = new String("ㅎㅎㅎ");
		String s = "뭘 할라 그래도 내용이 너무 없어가지고"; // String이 사실 객체였긴 함

		// 저 문장에서 3번째 글자만 가져오고 싶다 : 결과는 char <- !?
		System.out.println(s.charAt(2)); // 띄어쓰기도 엄연한 글자다
		System.out.println("-----");

		// 3 ~ 5번째 글자만 가져오고 싶다 : String
		System.out.println(s.substring(2, 5));
		System.out.println("-----");

		// 저 문장이 "뭘" 이라는 말로 시작하는지 체크해보고 싶다 : boolean
		System.out.println(s.startsWith("뭘"));
		System.out.println("-----");

		// 없 이라는 글자가 포함 되어있나? : boolean
		System.out.println(s.contains("없"));
		System.out.println("-----");

		// 총 글자수 : int
		System.out.println(s.length());
		System.out.println("-----");

		// 너무 -> 참 바꿔서 출력 : String
		System.out.println(s.replace("너무", "참"));
		System.out.println("-----");
		
		// 형식 지정해서 문자열 만들기
		String ss = String.format("%.2f", 2.234); // <- 꽤나 필요한 기능 GUI 때 느낌
		System.out.println(ss);
		System.out.println("-----");
		
		// 대문자에서 소문자로 바꾸기 (아멘's knowledge)
		String a = "BANANA";
		System.out.println(a.toLowerCase());
		
//		System.out.println(("ba"+2%0.0+"a").toLowerCase()); // (아멘's knowledge)
	}
}
