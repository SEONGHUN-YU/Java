package com.yu.jan122oop.Car;

public class CarFactory {
	private String name;
	// factory 공장은 굳이 생성자를 default로 할 필요는 없긴하다
	// 단, 공장에서 찍어내는 객체들은 생성자 default로 바꾸는 게 필수다
// 다형성 : 상위타입 변수에 하위타입 값을 넣을 수 있다! 중요
	public Car make(String type) {
		if (type.equals("버스")) {
			return new Bus();
		} else if (type.equals("트럭")) {
			return new Truck();
		} else {
			return new Sedan();
		}
	}
}
