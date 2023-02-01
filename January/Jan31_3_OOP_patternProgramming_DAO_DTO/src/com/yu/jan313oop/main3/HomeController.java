package com.yu.jan313oop.main3;

import java.util.ArrayList;

// 카테고리별 상품갯수
public class HomeController {
	public static void main(String[] args) {
		ArrayList<CategoryCount> alc = ShopDAO.getCount();
		ConsoleScreen.print(alc);
	}
}
