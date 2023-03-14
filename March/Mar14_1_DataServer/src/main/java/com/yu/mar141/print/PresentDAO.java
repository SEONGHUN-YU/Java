package com.yu.mar141.print;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentDAO {

	@Autowired
	private SqlSession ss;

	public void get(HttpServletRequest req) {
		List<PresentBean> presents = ss.getMapper(PresentMapper.class).get();
		req.setAttribute("presents", presents);
	}
	
	public Presents getXML(HttpServletRequest req) {
		List<PresentBean> presents = ss.getMapper(PresentMapper.class).get();
		return new Presents(presents);
	}
}
