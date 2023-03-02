package com.yu.mar022mb.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SelectMain {
	public static void main(String[] args) {
		// 서버가 어쩌고x, SQL문이 어쩌고x
		// ORM
		// .close(); 해줄 것들 줄어서 좋고
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("abcd.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();

			// Avengers - Ironman
			// List - ArrayList
			List<Snack> snacks = ss.selectList("snackMapper.getSnack");
			// xml의 namespace값 + . + 불러올 쿼리 id값

			for (Snack s : snacks) {
				System.out.println(s.getS_name());
				System.out.println(s.getS_price());
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
