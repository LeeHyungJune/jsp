package com.githrd.test;

import java.io.*;
import java.sql.*;


import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.githrd.test.dao.*;
import com.githrd.test.vo.*;


@WebServlet("/test/myInfo.pink")
public class myInfo extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//		할일
			//	0. 세션 검사
			req.setCharacterEncoding("utf-8");
			
			HttpSession session = req.getSession();
			
			/*
			if(session.getAttribute("SID") == null) {
				resp.sendRedirect("/whistle/test/login.pink");
				return;
			}
			*/
			
			String pid = (String)session.getAttribute("SID");

			
			MemberDao mDao = new MemberDao();
			
			MemberVO mVO =  mDao.getMyInfo(pid);
			
			PrintWriter pw = resp.getWriter();
			pw.println("{");
			pw.println("\"mno\": \""  + mVO.getMno() + "\",");
			pw.println("\"name\": \"" + mVO.getName() + "\",");
			pw.println("\"id\":   \"" + mVO.getId() + "\",");
			pw.println("\"mail\": \"" + mVO.getMail() + "\",");
			pw.println("\"tel\": \"" + mVO.getTel() + "\",");
			pw.println("\"hdate\": \"" + mVO.getHdate() + "\",");
			pw.println("\"gen\": \"" + mVO.getGen() + "\"");
			pw.println("}");
			
			/*int mno = mVO.getMno();
			String name = mVO.getName();
			String mid = mVO.getId();
			String mail = mVO.getMail();
			String tel = mVO.getTel();
			String sdate = mVO.getSdate();
			String gen = mVO.getGen();*/
	}

}
