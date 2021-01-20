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

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User dto = (User) session.getAttribute("current_user");
		UserDao.delete(dto);

		session.invalidate();
		response.sendRedirect("/signup");
	}
}
