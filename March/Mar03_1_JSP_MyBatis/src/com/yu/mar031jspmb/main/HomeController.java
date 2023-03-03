package com.yu.mar031jspmb.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yu.mar031jspmb.snack.SnackDAO;

import seonghun.yu.db.manager.YUDBManager;

// 톰캣이 관리하니 -> 프로젝트 경로는 무관
// Controller는 WebContent에 있다고 보면 됨
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
		YUDBManager.getYUDBM().setSSFactory("com/yu/mar031jspmb/main/config.xml");
		SnackDAO.getDAO().setAllSnackCount();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SnackDAO.getDAO().get(request, 1);
		request.setAttribute("cp", "home.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
