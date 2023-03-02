package com.yu.mar022mb.main;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 기본연결
// 입력받기

// YUDBManager_v3.0.jar 만들어야 할까?
// Spring + MyBatis <- 여기가면 또 다르게 해야함
// JSP Model 2 + MyBatis <- 실전에선 이렇게 하는 회사도 많이 있음
// Java + MyBatis : Java로 분석용데이터구축 프로그램 만들꺼면 v3.0.jar 만들어도 나쁘지 않음
public class InsertMain {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("abcd.xml");
			ss = new SqlSessionFactoryBuilder().build(is).openSession();

			System.out.print("이름 : ");
			String n = k.next();
			System.out.print("가격 : ");
			int p = k.nextInt();
			// ${어트리뷰트명} JSP에서는 이거였는데
			// #{멤버변수명} MyBatis에서는 이렇게

//			BigDecimal bd = k.nextBigDecimal(); <- Scanner일 때는 있긴 함...
			// int, double은 MyBatis에서 사용하기 위해 BigDecimal로 만들어줘야 함
			int i = 10; // int -> BigDecimal
			BigDecimal ii = new BigDecimal(i); // BigDecimal -> int
			int iii = ii.intValue();

			Snack s = new Snack(n, new BigDecimal(p));

			// 연결해서 작업 쭉 한 다음에 : DB서버에 실제로 반영은 안 됨
			// commit을 수행하면 DB서버에 반영됨
			// rollback을 수행하면 취소됨
			
			// eclipse/JDBC/ConnectionPool : auto commit
			// pstmt <- 1회용이었던 이유가 auto commit이었어서
			// MyBatis는 수동 commit
			int row = ss.insert("snackMapper.regSnack", s);
			if (row == 1) {
				System.out.println("성공");
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
		k.close();
	}
}
