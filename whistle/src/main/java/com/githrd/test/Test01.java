package com.githrd.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/test02.pink")
/*
 	@WebServlet("요청내용")
 	==>	요청내용으로 서버에 요청을 하면
 		이 클래스를 실행해서 응답문서를 만들어서 응답하세요.
 		라는 의미
 		
 		이 어노테이션 처럼
 		요청내용에 따라서 실행할 클래스를 지정하는 것을
 		요청매핑이라고 표현한다.
 */
public class Test01 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) 
							throws ServletException, IOException{
		req.setAttribute("NAME", "jennie");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/test/test01.jsp");
		rd.forward(req, resp);
	}
}
