package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email.equals("deep@gmail.com") && password.equals("1234")) {
			HttpSession hs = req.getSession();
			System.out.println(hs.getId());
			System.out.println("session  "+hs.isNew());
			System.out.println(new Date(hs.getCreationTime()));
			hs.setAttribute("email", email);
			resp.sendRedirect("deepsingh2");
		} else {
			resp.getWriter().print("Login Failed");
			req.getRequestDispatcher("deep.html").include(req, resp);
		}

	}
}
