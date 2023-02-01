package com.yu.feb012ad.main;

import java.util.ArrayList;

public class Console {
	public static void print(ArrayList<LocationCount> alc) {
		for (LocationCount l : alc) {
			System.out.println(l.getLocation());
			System.out.println(l.getCount());
			System.out.println("-----");
		}
	}
}
