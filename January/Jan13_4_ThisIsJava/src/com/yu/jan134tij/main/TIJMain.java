package com.yu.jan134tij.main;

import java.util.Calendar;
import java.util.Scanner;

import com.yu.jan133eh.calculator.Calculator;

// 장인어른 : 새로운 프로젝트가 시작됐다는 설정 (나는 신입)
public class TIJMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.println("총 금액 : ");
		int all = k.nextInt();

		System.out.println("물건 갯수 : ");
		int count = k.nextInt();

		System.out.println("-----");

//		int result = Calculator.divide(all, count);
//		System.out.println(result);
		
		try { // throws 해결
			int result = Calculator.divide2(all, count);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("오타십니다");
		}
	}
}
