package com.yu.jan121oop.main;

import com.yu.jan121oop.product.Book;
import com.yu.jan121oop.product.Food;
import com.yu.jan121oop.product.Product;

// 다차원배열 vs 1차원객체배열
// 근데 사실 배열 자체를 잘 안 쓴다 함, 단점이 좀 있는 것 같다
public class OMain2 {
	public static void main(String[] args) {
		// 자료형도 못 섞는 2차원배열 쓸 바에 1차원객체배열 쓰고 말지
		Product[] products = new Product[3];
		products[0]= new Food("새콤달콤", 300, "내일");
		products[1]= new Book("삼국지", 10000, "이문열");
		products[2]= new Food("칸쵸", 500, "오늘");
		
		// 첫번째 상품 가격 출력
		System.out.println(products[0].getPrice());
		// 두번째 상품의 상품명 출력
		System.out.println(products[1].getName());
	}
}
