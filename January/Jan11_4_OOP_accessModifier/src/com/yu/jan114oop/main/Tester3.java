package com.yu.jan114oop.main;

import com.yu.jan114oop.product.Mask;

// Mask, Tester3
//		패키지 다름, 상속관계(protected가 왜 안 되지?)

public class Tester3 extends Mask {

	public void test() {
		Mask m = new Mask();
		m.a = 1;
//		m.b = 2;
//		m.c = 3;
//		m.d = 4;
	}
}
