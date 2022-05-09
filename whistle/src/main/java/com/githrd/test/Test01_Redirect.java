package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test01_Redirect extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp)
								throws ServletException, IOException {
		req.setAttribute("NAME", "jennie");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/test01_redirect.jsp");
		rd.forward(req, resp);
	}
}
