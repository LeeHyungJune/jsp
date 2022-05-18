package com.githrd.jennie.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.githrd.jennie.controller.*;
import com.githrd.jennie.dao.*;

public class IdCheck implements BlpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	이 함수는 비동기 통신 처리용 함수이므로
		req.setAttribute("isRedirect", null);
		
		StringBuffer buff = new StringBuffer();
		/*
		 	이 함수에서의 작업은 
		 	비동기 통신에서 요청한 json 문서를  만들어서 반환해주면 된다.
		 	이때 json 문서를 만드느 것이 아니고
		 	json 형식의 문자열을 만들어서 반환해주면
		 	그 문자열을 디스패치 컨트롤러에서 문서로 만드는 작업을 하게 된다.
		 */
		
		//	할일
		//	파라미터 꺼내고
		String id = req.getParameter("id");
		//	데이터베이스에 문의
		MemberDao mDao = new MemberDao();
		//	결과받고
		int cnt = mDao.getIdCount(id);
		
		//	결과에 따라 처리
		buff.append("{");
		buff.append("\"result\" : \"");
		if(cnt == 0) {
			//	사용 가능한 아이디인 경우
			buff.append("OK");
		} else {
			//	사용 불가능한 아이디인 경우
			buff.append("NO");
		}
		buff.append("\"");
		buff.append("}");
		//	응답문서 내용 반환
		
		return buff.toString();
	}

}