package com.yu.jan135uc.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class UCMain4 {
	public static void printPlus(String a) {
		StringTokenizer st = new StringTokenizer(a, ",");
		int sum = 0;
		while (st.hasMoreTokens()) {
			try { // try와 catch의 위치가 중요
				sum += Integer.parseInt(st.nextToken());
			} catch (Exception e) {
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("숫자 (a,b,c,...) : ");
		String n = k.next();
		System.out.println("-----");
		printPlus(n);

		// "," 기준으로 나눠서 잘라야 하지 않을까?
		// 일단 글자는 없다고 치고
		// 글자 들어갔을 때 처리

//		String[] n2 = n.split(","); <- 이런 방법도 있음
//		for (String s : n2) {
//			System.out.println(s);
//		}
	}
}
