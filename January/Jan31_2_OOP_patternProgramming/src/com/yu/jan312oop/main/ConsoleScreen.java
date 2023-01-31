package com.yu.jan312oop.main;

import java.util.Scanner;

// V
public class ConsoleScreen {
	// Systim.in : 콘솔에서 쓴 것 -> 프로그램으로 가져올 때 쓰는 빨대
	// Scanner : 빨대 보조기구쯤 ?
	private Scanner inputSystem;

	public ConsoleScreen() {
		inputSystem = new Scanner(System.in);
	}

	public int getNoX() {
		System.out.print("x : ");
		return inputSystem.nextInt();
	}

	public int getNoY() {
		System.out.print("y : ");
		return inputSystem.nextInt();

	}

	public void print(CalcResult cr) {
		System.out.println(cr.getHab());
		System.out.println(cr.getCha());
		System.out.println(cr.getGob());
		System.out.println(cr.getMoks());
	}

	public void destroy() {
		inputSystem.close();
	}

}
