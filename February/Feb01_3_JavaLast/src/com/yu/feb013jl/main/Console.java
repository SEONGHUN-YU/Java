package com.yu.feb013jl.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.yu.feb013jl.cvs.CVS;
import com.yu.feb013jl.snack.CVS_Snack;
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
		System.out.println("3. 편의점 전체 조회");
		System.out.println("4. 간식 전체 조회");
		System.out.println("5. 편의점 찾기");
		System.out.println("6. 간식 찾기");
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
		System.out.print("판매점 번호 : ");
		int r = inputSystem.nextInt();
		return new Snack(0, q, w, r, e);
	}

	public void showAllCVS(ArrayList<CVS> cvs) {
		for (CVS c : cvs) {
			System.out.print(c.getNo() + ") ");
			System.out.print(c.getName() + "(");
			System.out.println(c.getLocation() + ")");
			System.out.println(c.getAddr());
			System.out.println();
		}
	}

	// 날짜 요일까지 보여달라 -> 보여지는 형태 -> 디자인의 영역
	// Date의 출력형식을 V를 담당하는 디자이너가 SimpleDateFormat?
	// 개발자가 SimpleDateFormat 쓸 줄 알텐데, 개발자의 업무는 아니고...
	// => 디자이너가 날짜 형식 간단하게 처리할 수 있는 기술이 필요하지 않을까?
	// 나중에 웹 배울 때 할 수 있을 것

	public void showAllSnack(ArrayList<Snack> snacks) {
		for (Snack s : snacks) {
			System.out.print(s.getNo() + ") ");
			System.out.print(s.getName() + " - ");
			System.out.println(s.getPrice() + "원");
			System.out.println(s.getExp() + "까지");
			System.out.println();
		}
	}

	public int showSelectPageMenu(int pageCount) {
		System.out.printf("몇 페이지(1 ~ %d) : ", pageCount);
		return inputSystem.nextInt();
	}

	public void printResult(String result) {
		System.out.println(result);
	}

	public String showSearchMenu() {
		System.out.print("검색어 : ");
		return inputSystem.next();
	}

	public void showSearchSnack(ArrayList<CVS_Snack> cs_AL) {
		for (CVS_Snack cv : cs_AL) {
			System.out.print(cv.getS_name() + " : ");
			System.out.print(cv.getS_price() + "원 (");
			System.out.print(cv.getC_name() + " ");
			System.out.println(cv.getC_location() + ")");
		}
	}

	public void destroy() {
		inputSystem.close();
	}
}
