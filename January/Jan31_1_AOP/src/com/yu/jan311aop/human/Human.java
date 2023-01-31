package com.yu.jan311aop.human;

public class Human {

	private void ready() {
		System.out.println("씻고");
		System.out.println("옷 입고 신발 신고");
		System.out.println("엘베 타고 내려가서");
	}

	public void goToSchool() {
		ready();
		System.out.println("마을버스 타고 지하철역 가서");
		System.out.println("지하철 타고 또 타고");
		System.out.println("도착");
	}

	public void goToMart() {
		ready();
		System.out.println("걸어가서");
		System.out.println("도착");
	}

	public void goToPark() {
		ready();
		System.out.println("자전거 타고 가서");
		System.out.println("도착");
	}
}
