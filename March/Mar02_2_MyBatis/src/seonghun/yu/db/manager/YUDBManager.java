package seonghun.yu.db.manager;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 패턴 : 그렇게밖에 못 하게
// 완전한 싱글턴을 못 해서 아쉬운데, 고민을 해볼까
// => Java/JSP + MyBatis <- 에서만 쓸 수 있음
// => Spring + MyBatis 가면 어차피 이런식으로 안 함, 연결을 Spring이 관리해버리기 때문에
public class YUDBManager {
	private SqlSessionFactory ssf;

	private static final YUDBManager YUDBM = new YUDBManager();

	private YUDBManager() {
	}

	public static YUDBManager getYUDBM() {
		return YUDBM;
	}

	public void setSSFactory(String cfgFile) {
		try {
			InputStream is = Resources.getResourceAsStream(cfgFile);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			ssf = ssfb.build(is);
		} catch (Exception e) {
		}
	}

	public SqlSessionFactory getSSFactory() {
		return ssf;
	}
}
