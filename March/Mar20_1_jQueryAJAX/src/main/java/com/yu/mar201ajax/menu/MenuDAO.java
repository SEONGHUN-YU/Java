package com.yu.mar201ajax.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	@Autowired
	private SqlSession ss;

	public void get(HttpServletRequest req) {
		req.setAttribute("menus", ss.getMapper(MenuMapper.class).get());
	}

	public Menus getXML() {
		List<Menu> menus = ss.getMapper(MenuMapper.class).get();
		return new Menus(menus);
	}

	public String reg(Menu m) {
		try {
			if (ss.getMapper(MenuMapper.class).reg(m) == 1) {
				return "<result>성공</result>";
			}
			return null;
		} catch (Exception e) {
			return "<result>실패</result>";
		}
	}

	public Menus searchXML(Menu m) {
		return new Menus(ss.getMapper(MenuMapper.class).search(m));
	}
}
