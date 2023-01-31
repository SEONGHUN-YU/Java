package com.yu.jan312oop.project;

// 결과가 여러개 나오면 고민이다 : [], List, Set, Map ??? 가능은 한데... 객체지향인데 ㅠ
// 데이터 묶어서...객체로!

// M
public class Calculator {
	public static CalcResult calulate(int x, int y) {
		int q = x + y;
		int w = x - y;
		int e = x * y;
		int r = x / y;
		return new CalcResult(q, w, e, r);
	}
}
