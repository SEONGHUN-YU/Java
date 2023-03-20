package com.yu.mar201ajax.product;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {

	@Autowired
	private SqlSession ss;

	public void get(HttpServletRequest req) {
		// 코드 재활용해서 못 쓰게 됨
//		req.setAttribute("products", ss.getMapper(ProductMapper.class).get(new ProductSelector(여기가, 애매)));
	}

	public Products getJSON(int page) {
		int allProductCount = ss.getMapper(ProductMapper.class).getAllProductCount();
		int pageCount = (int) Math.ceil(allProductCount / 3.0);
		if (page <= pageCount) {
			int start = (page - 1) * 3 + 1;
			int end = page * 3;
			return new Products(ss.getMapper(ProductMapper.class).get(new ProductSelector(start, end)));
		}
		return null;
	}
}
