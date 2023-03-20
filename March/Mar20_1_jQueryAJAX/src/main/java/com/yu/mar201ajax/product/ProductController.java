package com.yu.mar201ajax.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	@Autowired
	private ProductDAO pDAO;

	@RequestMapping(value = "/outputjson.go", method = RequestMethod.GET)
	public String outputJSONGo(HttpServletRequest req) {
		pDAO.get(req);
		req.setAttribute("cp", "outputjson.jsp");
		return "index";
	}

	@RequestMapping(value = "/product.get.json", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Products productGetJSON(@RequestParam(value = "page") int page, HttpServletResponse res) {
		res.setHeader("Access-Control-Allow-Origin", "*");
		// cross-domain ajax 가능하게 해주는 코드 "*"는 모두에게, "ip 적으면 그 특정 ip에게만"
		return pDAO.getJSON(page);
	}
}
