package com.yu.jan312oop.project;

// 프로젝트가 커지면 C도 많아짐
// 그 중에 프로그램 진입점 역할을 해주는 첫 C를
// 일반적으로 HomeController/MainController 라고 부른다

// x : 7
// y : 3
//----------
// +-*/ 사칙연산

// C
public class HomeController {
	public static void main(String[] args) {
		ConsoleScreen cs = new ConsoleScreen();
		int x = cs.getNoX();
		int y = cs.getNoY();
		CalcResult cr = Calculator.calulate(x, y);
		cs.print(cr);
		cs.destroy();
	}
}
