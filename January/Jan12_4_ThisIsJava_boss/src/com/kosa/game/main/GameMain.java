package com.kosa.game.main;

import com.kosa.game.character.IronMan;

// Java라는 언어는 거의 다 배움

// part1 : PP
// part2 : OOP
// part3 : 앞으로 작업을 해나갈 때 유용하지 싶은 클래스들 소개 
// Java에 내장된 클래스, 다른 개발자가 만들어준 클래스 소개

// 나중에가서 메소드명이 어쩌고 그러면 안 되지!

// 추상메소드 : 반드시 그 작업을 할 수밖에 없음
// => 추상클래스 or 인터페이스 중에 골라야겠네
// => Java는 다중상속이 안 됨
// => 추상클래스로 주면(다중상속이 안 되니까) 상속라인을 막게 됨
// => 상속라인을 막지 않는 인터페이스로 하자
public class GameMain {
	public static void main(String[] args) {
		IronMan i = new IronMan();
		i.shootBeam();
	}
}
