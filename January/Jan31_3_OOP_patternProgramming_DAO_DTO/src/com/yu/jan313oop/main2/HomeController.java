package com.yu.jan313oop.main2;

import java.util.ArrayList;

// MVC패턴 : 디자이너/개발자 분업
// V도 새로 - 디자이너 (화려한 자바코드x)
// M도 새로 - 개발자 (복잡한 거 여기)

// 상품명, 가격조회
// 상품명 가나다 -> 가격 싼 순

public class HomeController {
	// DAO가서 상품 데이터 가지고 와서
	// V에서 출력
	public static void main(String[] args) {
		try {
			ArrayList<Shop> Shops = ShopDAO.getShop();
			ConsoleScreen.print(Shops);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
