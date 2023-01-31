package com.yu.jan313oop.main;

import java.util.Scanner;

// V
public class ConsoleScreen {
	private Scanner inputSystem;

	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}

	public Restarea getRestarea() throws Exception {
		System.out.print("휴게소 이름 : ");
		String n = inputSystem.next();

		System.out.print("방향 : ");
		String s = inputSystem.next();

		System.out.print("위치 : ");
		String w = inputSystem.next();

		System.out.print("주차 대수 : ");
		int p = inputSystem.nextInt();

		return new Restarea(0, n, s, w, p);
	}
	
	public void print(String result) {
		System.out.println(result);
	}

	public void kill() {
		inputSystem.close();
	}

}
