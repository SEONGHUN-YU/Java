package com.yu.mar022mb.main;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// ojdbc?.jar : Java랑 OracleDB랑 연동
// mybatis.jar : MyBatis

// MyBatis : DB ORM Framework
//		Object Relationship Mapping
//		Java객체 - DB에 있는 데이터랑 Mapping(?) 해줌
//		자체적으로 ConnectionPool임 -> Tomcat 필요 없음

//		ResultSet rs;
//		ArrayList<Coffee> al;
//		while(rs.next()){
//			al.add(new Coffee(a, b, c));
//		{
//		V에서 EL+JSTL로 상대 <- JSP 시절 방법

//						DB서버			SQL
// JDBC					.java			.java
// ConnectionPool		context.xml		.java
// ---------------------------------------------- Connection 객체를 썼었음
// MyBatis				???.xml			.xml
// ---------------------------------------------- SqlSession 객체를 씀

// 2.x : iBatis
// 3.x : MyBatis

// 내부적으로 어떻게 돌아가나? - 모름...
public class ConnectMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("abcd.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is); // 튜브대여소
			ss = ssf.openSession();
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
