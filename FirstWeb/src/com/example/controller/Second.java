package com.example.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Second extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logic(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logic(req, resp);
	}

	private void logic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		if (email.equals("deep@gmail.com") && pass.equals("1234")) {
			getServletContext().setAttribute("email", email);
			resp.sendRedirect("deepsingh2");
		} else {
			resp.getWriter().print("Login Failed");
		}
		req.getRequestDispatcher("deep.html").include(req, resp);
	}
}
