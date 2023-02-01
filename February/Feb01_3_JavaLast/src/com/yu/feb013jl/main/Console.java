package com.yu.feb013jl.main;

import java.util.Scanner;

import com.yu.feb013jl.cvs.CVS;
import com.yu.feb013jl.snack.Snack;

public class Console {
	private Scanner inputSystem;

	public Console() {
		inputSystem = new Scanner(System.in);
	}

	public int showMainMenu() {
		System.out.println("-----");
		System.out.println("1. 편의점 등록");
		System.out.println("2. 간식 등록");
		System.out.println("10. 종료");
		System.out.println("-----");
		System.out.print("고르세요 : ");
		return inputSystem.nextInt();
	}

	// ctrl + shif + /(numpad)
	public CVS showRegCVSMenu() {
		System.out.print("이름 : ");
		String q = inputSystem.next();
		System.out.print("지점명 : ");
		String w = inputSystem.next();
		System.out.print("주소 : ");
		String e = inputSystem.next();
		return new CVS(0, q, w, e);
	}

	public Snack showRegSnackMenu() {
		System.out.print("이름 : ");
		String q = inputSystem.next();
		System.out.print("가격 : ");
		int w = inputSystem.nextInt();
		System.out.print("유통기한[YYYYMMDD] : ");
		String e = inputSystem.next();
		System.out.println("판매점 번호 : ");
		int r = inputSystem.nextInt();
		return new Snack(0, q, w, r, e);
	}

	public void destroy() {
		inputSystem.close();
	}
}
