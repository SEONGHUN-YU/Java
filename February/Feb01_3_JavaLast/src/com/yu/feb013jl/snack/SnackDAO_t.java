package com.yu.feb013jl.snack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yu.feb013jl.main.StudyKey;

import seonghun.yu.db.manager.YUDBManager;

// 왜 static 안 하고? 왜 singleton으로 함?
// 나중에 바꾸면 수정하기가 불편할테니
public class SnackDAO_t {

	private static final SnackDAO_t SDAO = new SnackDAO_t();
	private int allSnackCount;
	private int snackPerPage;

	// SnackDAO : singleton 패턴 -> 한 번만 만들어짐
	// 그 한 번 만들어질 때 간식 갯수를 세자
	// 그러고나서 allSnackCount 변수에 저장해놨음
	// 등록하면 allSnackCount하나 더하고
	// 등록하면 allSnackCount하나 빼고
	private SnackDAO_t() {
		setAllSnackCount(); // 여기다 넣고, 처음 한 번만 세자
		snackPerPage = 3;
	}

	public static SnackDAO_t getSDAO() {
		return SDAO;
	}

	public int getAllPageCount() {
		// allSnackCount / snackPerPage = 14 / 3 = 4
		// allSnackCount / (double) snackPerPage = 14 / 3.0 = 4.666
		// Math.ceil(allSnackCount / (double) snackPerPage) = 5.0
		return (int) Math.ceil(allSnackCount / (double) snackPerPage);
	}

	private void setAllSnackCount() { // <- 밖에서 쓸 거 아니니까 private
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select count(*) from snack";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allSnackCount = rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	// 실전에서 전체 조회라는 건 없음
	public ArrayList<Snack> getAllSnack(int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			int start = (page * snackPerPage) - 2;
//			int end = (page == getAllPageCount()) ? allSnackCount : (page * snackPerPage); // 사실 이렇게까지 안 해도 SQL이 자동으로 해준다...
			int end = page * snackPerPage;

//			getAllSnackCount(); // 조회할 때마다 세야하나? 아니지...
//			System.out.println(allSnackCount); // 이런식으로 조회를 하면 될 것을!

			String sql = "select * from(select rownum as rn, s_no, s_name, s_price, s_exp from(select s_no, s_name, s_price, s_exp from snack order by s_name, s_price)) where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<Snack> snacks = new ArrayList<>();
			Snack s = null;
			while (rs.next()) {
				s = new Snack();
				s.setNo(rs.getInt("s_no"));
				s.setName(rs.getString("s_name"));
				s.setPrice(rs.getInt("s_price"));
				s.setExp(rs.getDate("s_exp")); // ???
				snacks.add(s);
			}
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	// 1. JDBC -> ConnectionPool -> MyBatis
	// JDBC : java.sql.Date를 쓰는데
	// 최종테크 MyBatis : java.util.Date를 씀

	// 2. 실무상황 생각해야지 (MVC패턴에서 Date처리 같은)
	// 애초에 view한테 Date로 안 받았음...

	// 3. java.sql.Date -> java.util.Date로 알아서 형변환 됨

	// java 주력 : java.util.Date
	// DB작업하라고 만든 : java.sql.Date <- 근데 실전에서 안 씀, 걍 이런 게 있다고만 알아

	public String reg(Snack s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "insert into snack values(snack_seq.nextval, ?, ?, to_date(?,'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getPrice());
			pstmt.setString(3, s.getExp_pre());
			pstmt.setInt(4, s.getCvsno());

			if (pstmt.executeUpdate() == 1) {
				allSnackCount++; // 등록성공 때 올린다
				return "간식 등록 성공";
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "간식 등록 실패";
		}
	}
}
