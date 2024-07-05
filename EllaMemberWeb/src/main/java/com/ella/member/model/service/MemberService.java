package com.ella.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.ella.common.JDBCTemplate;
import com.ella.member.model.dao.MemberDAO;
import com.ella.member.model.vo.Member;

public class MemberService {
	private MemberDAO mDao;
	
	public MemberService() {
		mDao = new MemberDAO();
	}

	public int insertMember(Member member) {
		Connection conn = null;
		int result = 0;
		try {
			conn = JDBCTemplate.getConnection();
			result = mDao.insertMember(conn, member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member checkLogin(Member member) {
		Connection conn = null;
		Member mOne = null;
		try {
			conn = JDBCTemplate.getConnection();
			mOne = mDao.checkLogin(conn, member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mOne;
	}

}
