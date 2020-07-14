package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if (hs != null) {
			hs.removeAttribute("email");
			hs.invalidate();
		} else {
			resp.getWriter().print("please login first");
		}
		req.getRequestDispatcher("deep.html").include(req, resp);
	}

}
