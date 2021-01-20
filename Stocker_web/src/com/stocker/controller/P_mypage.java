package com.stocker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stocker.dao.UserDao;
import com.stocker.model.User;

@WebServlet("/mypage")
public class P_mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "mypage");
		request.setAttribute("styles", new String[] {"mypage"});
		request.getRequestDispatcher("/WEB-INF/jsp/template/template.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User dto = (User) request.getSession().getAttribute("current_user");
		dto.setNm(request.getParameter("nm"));
		
		UserDao.update(dto);
		
		response.sendRedirect("/mypage");
	}
}
