package seonghun.yu.db.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 앞으로 자주 쓸 것 같은 기능을 라이브러리로 만들자 -> 다양한 상황에서 쓸 수 있게
// static 활용
// throws 활용
// 이런 생각을 했다고!?

public class YUDBManager {

	public static Connection hello(String url, String id, String pw) throws SQLException {
		return DriverManager.getConnection(url, id, pw);
	}

	public static void world(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}

}
