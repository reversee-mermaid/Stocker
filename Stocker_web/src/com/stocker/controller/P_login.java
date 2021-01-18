package com.stocker.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stocker.dao.UserDao;
import com.stocker.model.User;

@WebServlet("/login")
public class P_login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "login");
		request.setAttribute("styles", new String[] {"account"});
		request.getRequestDispatcher("/WEB-INF/jsp/template/template.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User dto = new User();
		dto.setEmail(request.getParameter("email"));
		dto.setPw(request.getParameter("pw"));
		
		User data = UserDao.select(dto);
		
		if(data != null) {
			HttpSession session = request.getSession();
			session.setAttribute("current_user", data);
			response.sendRedirect("/");
		} else {
			request.setAttribute("err_msg", "존재하지 않는 Email 혹은 Password 불일치");
			doGet(request, response);
		}
	}
}
