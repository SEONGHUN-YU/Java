package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

// Java프로그램 + OracleDB연결

// DB메이커가 다양함, 통신방식이 다 다른 정도까진 아니지만
// -> 최종적으로 DB서버에 연결하기 위한 어댑터(드라이버)가 없는 느낌
// Java입장에서 그걸 어떻게 다 작업을 하겠음...
// => 누가 만든 거 쓰면 되지 This Is Java!

// java : 전세계적으로 많이
// 개발자들이 자기가 작업한 거 공유하는 문화
// 소스는 까기 싫고, 기능만 공유
// -> .jar

// InstantClient 폴더
// ojdbc8.jar에 OracleDriver 들어있음

// Java : Sun사
// OracleDB : Oracle사

// Sun사가 Oracle에 먹히면서
// Java : Oracle사
// OracleDB : Oracle사

// 수업들은걸로 평생 못 먹고 살아 절대로
public class ConnectMain {
	public static void main(String[] args) {

		Connection con = null;
		try {
			// 최종적으로 연결할 때 OracleDriver 써
			// 쌩 Java할 때는 필요없음, JSP에서는 못 찾아서 써주기는 해야함
			Class.forName("oracle.jdbc.driver.OracleDriver"); // <- JSP할 때는 필요
			// ↑ 사실 이거 없어도 됨...

			// Data Source Explorer에서 DBServer 우클릭 - Properties
			// - Driver Properties - Connection URL 복사
			// 연결할 DB서버 주소 [DB메이커별로 폼이 다 다름]
			// 주소만 봐도 뭔 DB인지 알 수 있음
			// 주소만 봐도 뭔 드라이버 써야하는지 안다
			String addr = StudyKey.DBSERVER_ADDRESS;

			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			System.out.println("오류 안 나면 연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
