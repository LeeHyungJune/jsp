package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/test/login.pink")
public class Login extends HttpServlet {
		public void service(HttpServletRequest req, HttpServletResponse resp) 
				throws ServletException, IOException{
	
	req.setAttribute("ID", req.getParameter("id"));
	req.setAttribute("PW", req.getParameter("pw"));
	
	RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/Login.jsp");
	rd.forward(req, resp);
	}
}
