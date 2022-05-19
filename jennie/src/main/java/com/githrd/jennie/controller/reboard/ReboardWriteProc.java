package com.githrd.jennie.controller.reboard;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.vo.*;
import com.githrd.jennie.dao.*;


public class ReboardWriteProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("isRedirect", true);
		String view = "/whistle/reboard/reboardList.blp";
		//	할일
		//	로그인 체크
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/whistle/member/login.blp";
			return view;
		}
		//	파라미터 꺼내고
		String sno = req.getParameter("mno");
		String spage = req.getParameter("nowPage");
		String body = req.getParameter("body");
		
		BoardVO bVO = new BoardVO();
		bVO.setMno(Integer.parseInt(sno));
		bVO.setBody(body);
		
		//	데이터 베이스 작업
		ReboardDao rDao = new ReboardDao();
		int cnt = rDao.addReboard(bVO);
		
		//	결과에 따라서 처리
		if(cnt == 0) {
			req.setAttribute("isRedirect", false);
			//	view = "/whistle/reboard/reboardWrite.blp?nowPage" + spage;	//	get 방식
			
			//	post 방식 - forward 처리
			req.setAttribute("VIEW", "/whistle/reboard/reboardWrite.blp?");
			req.setAttribute("NOWPAGE", spage);
			
			return "/reboard/redirect";
		}
		
		return view;
	}

}
