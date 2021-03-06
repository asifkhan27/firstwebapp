package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if (hs != null) {
			String email = hs.getAttribute("email").toString();
			System.out.println("welcome.. " + email);
			resp.getWriter().print("Welcome " + email);
			resp.getWriter().print("<a href='logout'>Logout</a>");
			hs.setMaxInactiveInterval(60);
			

		} else {
			resp.getWriter().print("please login first");
			req.getRequestDispatcher("deep.html").include(req, resp);
		}
	}

}
