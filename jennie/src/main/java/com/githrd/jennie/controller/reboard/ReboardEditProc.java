package com.githrd.jennie.controller.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.githrd.jennie.controller.BlpInter;
import com.githrd.jennie.dao.ReboardDao;

public class ReboardEditProc implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = (String)req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/whistle/member/login.blp";
		}
		String view = "/reboard/redirect";
		
		String spage = req.getParameter("nowPage");
		String sno = req.getParameter("bno");
		String body = req.getParameter("body");
		int rbno = Integer.parseInt(sno);
		
		
		ReboardDao rDao = new ReboardDao();
		int cnt = rDao.editReboard(rbno, body);
		
		req.setAttribute("NOWPAGE", spage);
		if(cnt == 0) {
			//	실패
			req.setAttribute("VIEW", "/whistle/reboard/reboardEdit.blp");
		} else {
			req.setAttribute("VIEW", "/whistle/reboard/reboardList.blp");
		}
		
		return view;
	}

}
