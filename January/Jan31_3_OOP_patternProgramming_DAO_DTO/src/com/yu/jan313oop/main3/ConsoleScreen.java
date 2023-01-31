package com.yu.jan313oop.main3;

import java.util.ArrayList;

public class ConsoleScreen {
	public static void print(ArrayList<CategoryCount> alc) {
		for (CategoryCount categoryCount : alc) {
			System.out.println(categoryCount.getCategory());
			System.out.println(categoryCount.getCount());
		}
	}
}
