package com.stocker.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class P_home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// List<ArticleDto> list = ArticleDao.selectAll();
		
		// request.setAttribute("list", list);
		request.setAttribute("page", "home");
		request.getRequestDispatcher("/WEB-INF/jsp/template/template.jsp").forward(request, response);
	}
}
