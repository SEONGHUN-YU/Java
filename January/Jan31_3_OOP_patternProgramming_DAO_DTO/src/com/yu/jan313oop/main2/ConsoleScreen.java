package com.yu.jan313oop.main2;

import java.util.ArrayList;

public class ConsoleScreen {
	public static void print(ArrayList<Shop> shops) {
		for (Shop shop : shops) {
			System.out.println(shop.getName());
			System.out.println(shop.getPrice());
		}
	}
}
