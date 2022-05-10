package com.githrd.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.githrd.test.dao.MemberDao;


@WebServlet("/test/myInfo.pink")
public class myInfo extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
			//		할일
			//	0. 세션 검사
			HttpSession session = req.getSession();
			if(session.getAttribute("SID") == null) {
				resp.sendRedirect("/whistle/test/login.pink");
				return;
			}
			
			MemberDao mDao = new MemberDao();
			
			MemberVO mVO = mDao.getMyInfo(session.getId());

			System.out.println(mVO.getMno());
			System.out.println(mVO.getName());
			System.out.println(mVO.getId());
			System.out.println(mVO.getMail());
			System.out.println(mVO.getTel());
			System.out.println(mVO.getSdate());
			System.out.println(mVO.getGen());
			
			
			
			
			/*int mno = mVO.getMno();
			String name = mVO.getName();
			String mid = mVO.getId();
			String mail = mVO.getMail();
			String tel = mVO.getTel();
			String sdate = mVO.getSdate();
			String gen = mVO.getGen();*/
			
			
			
			
		
	}

}
