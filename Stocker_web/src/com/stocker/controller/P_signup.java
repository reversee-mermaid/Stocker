package com.stocker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stocker.dao.UserDao;
import com.stocker.model.User;

@WebServlet("/signup")
public class P_signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "signup");
		request.setAttribute("styles", new String[] {"account"});
		request.getRequestDispatcher("/WEB-INF/jsp/template/template.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User dto = new User();
		
		dto.setEmail(request.getParameter("email"));
		dto.setNm(request.getParameter("nm"));
		dto.setPw(request.getParameter("pw"));
		
		int result = UserDao.insert(dto);
		
		if(result == 1) {
			response.sendRedirect("/login");
		} else {
			request.setAttribute("err_msg", "이미 사용 중인 email입니다");
			doGet(request, response);
		}
	}
}
