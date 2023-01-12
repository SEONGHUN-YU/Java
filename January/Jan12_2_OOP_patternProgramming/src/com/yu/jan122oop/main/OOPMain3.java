package com.yu.jan122oop.main;

import com.yu.jan122oop.Car.Car;
import com.yu.jan122oop.Car.CarFactory;

// 자동차
//		번호
// 		정보출력 : 만들었다
public class OOPMain3 {
	public static void main(String[] args) {
		// 공장을 통해서 차를 만드는데
		// 만드는 차종이 type을 따르게
		CarFactory cf = new CarFactory();
		Car c1 = cf.make("트럭");
		c1.print();
		Car c2 = cf.make("버스");
		c2.print();
		Car c3 = cf.make("세단");
		c2.print();

	}
}
