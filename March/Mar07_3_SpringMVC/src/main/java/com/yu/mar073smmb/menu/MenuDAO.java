package com.yu.mar073smmb.menu;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	@Autowired
	private SqlSession ss;

	public void reg(Menu m) {
//		MenuMapper mm = ss.getMapper(MenuMapper.class); // (인터페이스명.class);
//		mm.reg(m);
		ss.getMapper(MenuMapper.class).reg(m);
	}
}
