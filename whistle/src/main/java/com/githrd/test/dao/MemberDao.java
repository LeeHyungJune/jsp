package com.githrd.test.dao;

import java.sql.*;

import com.githrd.test.db.*;
import com.githrd.test.sql.*;
import com.githrd.test.vo.MemberVO;

public class MemberDao {
	private JenyJDBC db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new JenyJDBC();
		mSQL = new MemberSQL();
		
	}
	
	//	로그인 데이터베이스 작업 전담 처리함수
	public int getLoginCnt(String id, String pw) {
		//	반환값 변수
		int cnt = 0;
		//	작업순서
		//	1.	커넥션 가져오기
		con = db.getCon();
		//	2.	질의명령 가져오기
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		//	3.	명령전달도구 꺼내오기
		pstmt = db.getPstmt(con, sql);
		try {
			//	4.	질의명령 완성
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			//	5.	질의명령 보내고 결과받기
			rs = pstmt.executeQuery();
			//	6.	결과에서 데이터 꺼내기
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		//	7.	데이터 반환
		return cnt;
	}
	
	public MemberVO getMyInfo(String id) {
		con = db.getCon();
		
		MemberVO mVO = new MemberVO();
		
		String sql = mSQL.getSQL(mSQL.SEL_MYINFO);
		
		pstmt = db.getPstmt(con, sql);
		
		try {
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			rs.next();
			
			int mno = rs.getInt("mno");
			String name = rs.getString("name");
			String mid = rs.getString("id");
			String mail = rs.getString("mail");
			String tel = rs.getString("tel");
			Date hdate = rs.getDate("joindate");
			Time htime = rs.getTime("joindate");
			String gen = rs.getString("gen");
			
			mVO.setMno(mno);
			mVO.setName(name);
			mVO.setId(mid);
			mVO.setMail(mail);
			mVO.setTel(tel);
			mVO.setHdate(hdate);
			mVO.setHtime(htime);
			mVO.setSdate();
			mVO.setGen(gen);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}
}
