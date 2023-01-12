package com.yu.jan123oop.human;

// 3가지 종류

// class : 객체 만드는 게 가능
//			멤버변수 o
//			멤버상수 o
//			메소드 o
//			추상메소드 x

// abstract class : 객체 못 만듬
//			멤버변수 o
//			멤버상수 o
//			메소드 o
//			추상메소드 o

// interface : 객체 못 만듬
//			멤버변수 x
//			멤버상수 o
//			메소드 x
//			추상메소드 o 

// interface <- class보다 기능이 딸림
// 변수를 못 가진다 == 속성을 못 가진다 => 매우 큰 타격
// 멤버변수가 안됨 => 매우 큰 타격
// 멤버상수는 됨 => 변수말고 상수는 됨 final 같은거
// method도 안 됨;
// abstract method는 됨! 오잉?!

// 자바는 다중상속 안되니
// 열화버전 다중상속이 가능 하도록
// 클래스를 안 쓰고 -> 인터페이스를 씀
// 인터페이스 : 다중상속의 대체 개념?? <- ?
//				열화판 다중상속?? <- 아닌데? => 인터페이스 : 상호작용이라는 뜻


public interface Human {
	// private String name;
	public static final String NIGHT = "잠";
	// 생성자도 안 되고 getter setter도 안 되고...

	// public void goMart() { <- 메소드도 안 됨
	// System.out.println("마트가기");
	// }

	public abstract void eat();
}
