package com.ella.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TryCatchFinally;

import com.ella.member.model.service.MemberService;
import com.ella.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			String memberId = request.getParameter("memberId");
			String memberPw = request.getParameter("memberPw");
			
			Member member = new Member(memberId, memberPw);
			MemberService mService = new MemberService();
			member = mService.checkLogin(member);
			if(member!= null) {
				// 로그인 성공 -> 메인으로 이동
				// 세션 다음에 리다이렉트가 있어야한다!!!!
				HttpSession session = request.getSession(); // 로그인되면 정보를 저장하는곳 세션 생성
				session.setAttribute("memberId", member.getMemberId());
				session.setAttribute("memberName", member.getMemberName());
				response.sendRedirect("/index.jsp"); // "/" 이거랑 똑같음
//				System.out.println(member.getMemberId());
			} else {
				request.setAttribute("msg", "존재하지 않는 정보입니다");
				request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
			}
//			} else {
//				// 에러페이지로 이동
//				request.setAttribute("msg", "에러메시지");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
	}
}













