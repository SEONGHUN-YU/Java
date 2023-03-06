package com.yu.mar066sdi.point;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PointController {
	// GET : 요청파라메터가 주소에
	//		근데 인터넷 주소에 한글은 안됨
	//		ㅋ -> %2A로 바꿔서 주소에 담아야
	//		%2A -> ㅋ 원상복귀 시켜서 값 사용해야
	//		ㅋ -> %2A -> ㅋ : 톰캣이 알아서 <- GET방식은 톰캣 설정만 잘 해놨으면 한글처리 따로 필요없었음
	
	// POST : 요청파라메터가 내부적으로 전달
	//		req.setCharacterEncoding("utf-8"); <- Spring 와서는 이거 해줄 필요 없음
	//		web.xml에 한글설정 <- 이걸 해주면 다 해결되기 때문
	
	@Autowired
	private PointDAO pDAO;
	
	@RequestMapping(value = "/point.calculate", method = RequestMethod.POST)
	public String pointCalculate(PointInfo obj, HttpServletRequest req) {
		pDAO.calculate(obj, req);
		return "output";
	}
}
