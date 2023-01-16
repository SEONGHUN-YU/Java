package com.yu.jan135uc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// 숫자라서 숫자 - X
// 숫자로서 의미가 있으면 숫자
// 주민번호, 핸드폰번호는 String이 훨씬 낫다
// 용도따라서 선택하는 것
public class UCMain6 {
	public static void main(String[] args) throws ParseException {
		// 본인 무슨요일에 태어났나?
		try {
			String birth = "1996-01-13";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date a = sdf.parse(birth);
			sdf = new SimpleDateFormat("E", Locale.ENGLISH); // 언어 지정하고 싶을 때 이런식으로
			String day = sdf.format(a);
			System.out.println(day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-----");

		// 이름 : 홍길동
		// 생년월일 : 1999/03/03(25살 - 한국나이)
		// 국어 : 100
		// 영어 : 90
		// 수학 : 50
		// 평균 : ??

		try {
			String student = "홍길동,19990303,100,90,50";
			String[] s = student.split(",");
			int[] a = new int[s.length]; // 내 방법
			for (int i = 1; i < s.length; i++) {
				a[i] = Integer.parseInt(s[i]);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			String curYear = sdf.format(new Date());
			int cy = Integer.parseInt(curYear);
			int age = cy - Integer.parseInt(s[1].substring(0, 4)) + 1;
			System.out.printf("이름 : %s\n", s[0]);
			System.out.printf("생년월일 : %s/%s/%s(%d살)\n", s[1].substring(0, 4), s[1].substring(4, 6),
					s[1].substring(6, 8), age);
			System.out.printf("국어 : %d\n", a[2]);
			System.out.printf("영어 : %d\n", a[3]);
			System.out.printf("수학 : %d\n", a[4]);
			int b = (a[2] + a[3] + a[4]) / 3;
			double avg = (double) b;
			System.out.printf("평균 : %.1f\n", avg);
		} catch (Exception e) {
		}

		// 쌤의 풀이
//		System.out.println(s[0]); _1
//		System.out.println(s[1]); _2

		// 한국 나이 구하는 과정
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		Date birthDay = sdf.parse(s[1]);
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd(E)");
//		System.out.println(sdf2.format(birthDay));
//		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy");
//		String birthYear = sdf3.format(birthDay);
//		int by = Integer.parseInt(birthYear);
//		String curYear = sdf3.format(new Date());
//		int cy = Integer.parseInt(curYear);
//		System.out.println(cy - by + 1); <- 최종결과물 (한국나이)

//		int kor = Integer.parseInt(s[2]); String -> int
//		int eng = Integer.parseInt(s[3]); 변환
//		int mat = Integer.parseInt(s[4]); 시키기
//		System.out.println(kor); _3
//		System.out.println(eng); _4
//		System.out.println(mat); _5
//		System.out.println((kor + eng + mat) / 3.0); _6
	}
}
