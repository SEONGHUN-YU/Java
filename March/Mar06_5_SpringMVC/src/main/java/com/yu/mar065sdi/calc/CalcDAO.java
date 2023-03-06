package com.yu.mar065sdi.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// servlet-context.xml에 등록한 효과
@Service
public class CalcDAO {
	public void calculate(XXXYYY xy, HttpServletRequest req) {
		int z = xy.getX() + xy.getY();
		req.setAttribute("zzz", z);
	}
}
