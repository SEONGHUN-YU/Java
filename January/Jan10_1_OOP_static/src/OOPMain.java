// 게시판에 질문글 올라왔다 치자
//		게장 얼마예요???
//		게장 무게 몇이에요???
//		게장 생산자 누구에요??? -> 이건 대답가능

// Java로 만든 프로그램 실행하려면
// JRE(Java Runtime Environment)가 필요
// JDK(Java Dev Kit) = JRE + 개발킷

// 자바의 특징중 하나
// WORA(Write Once Run Anywhere) -> 한번 써놓으면 아무데서나 돌아간다 (요즘은 특징이라 하긴 좀 그렇다함)
// OS별로 프로그램 따로 안 만들어도 됨

// 한국어로 설계 -번역(개발)-> .java
// .java -번역(compile)-> .class(기계어)
// .class -실행-> OS위에 JVM(Java Virtual Machine)이 만들어짐(구멍맞춘 사각형) - JRE
// 기계어로 번역된 소스들이 stack영역에 실림 ->
// static 멤버변수들이 static영역에 실림->
// JVM이 OOPmain.main(...)호출 -> ...

public class OOPMain {
	public static void main(String[] args) {
		System.out.println(Gejang.producer);

		// 게장
		Gejang a = new Gejang();
		// 품명이 설특선 간장게장세트
		a.name = "설특선 간장게장세트";
		// 무게가 10kg
		a.weight = 10;
		// 가격이 39900
		a.price = 39900;
		// 생산자가 김수미
		// 정보출력
		a.showInfo();
		System.out.println("-----");
		// 또다른 게장
		Gejang b = new Gejang();
		// 양념게장세트
		b.name = "양념게장세트";
		// 무게가 5kg
		b.weight = 5;
		// 가격이 29900
		b.price = 29900;
		// 생산자가 김수미
		// 정보출력
		b.showInfo();

	}
}
