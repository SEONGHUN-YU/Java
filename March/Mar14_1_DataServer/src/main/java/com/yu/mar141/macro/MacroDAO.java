package com.yu.mar141.macro;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MacroDAO {

	@Autowired
	private SqlSession ss;

	public void get(HttpServletRequest req) {
		req.setAttribute("macros", ss.getMapper(MacroMapper.class).get());
	}

	public Macros getJSON(HttpServletRequest req) {
		return new Macros(ss.getMapper(MacroMapper.class).get());
	}
}
