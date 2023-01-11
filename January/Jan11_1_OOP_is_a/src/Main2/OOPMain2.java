package Main2;

public class OOPMain2 {
	public static void main(String[] args) {
		// 고기
		// 메뉴명 티본스테이크
		// 가격 100000
		// 굽기 미디엄웰던
		// 정보출력
		Meat m = new Meat();
		m.menu = "티본스테이크";
		m.price = 100000;
		m.roast = "미디엄웰던";
		m.printInfo();
		System.out.println("-----");
	
		// 술
		// 메뉴명이 처음처럼
		// 가격이 2000
		// 도수가 15
		// 정보출력
		Soju s = new Soju();
		s.menu = "처음처럼";
		s.price = 2000;
		s.alcohol = 15;
		s.printInfo();


	}
}
