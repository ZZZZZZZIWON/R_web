package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/edit.do")
public class MemEditServlet extends HttpServlet {
	
	private MemberDao memberDao = new MemberDaoBatis();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getParameter("memId");
		MemberVo vo = memberDao.selectMember(memId);
		req.setAttribute("mvo", vo);
		
		req.getRequestDispatcher("/WEB-INF/views/member/memEdit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	{
		
		List<MemberVo> list = memberDao.selectMemberList(); // 이 DB관련 method를 실행시키는 코드

		req.setAttribute("memberList", list);
		req.getRequestDispatcher("/WEB-INF/views/member/memList.jsp").forward(req, resp);
//		
		MemberVo vo = new MemberVo(); // 파라미터의 갯수를 1개로 유지
		vo.setMemId(req.getParameter("memId")); // 요청 파라미터값 읽어온 것을 저장
		vo.setMemPass(req.getParameter("memPass")); // 요청 파라미터값 읽어온 것을 저장
		vo.setMemName(req.getParameter("memName")); // 요청 파라미터값 읽어온 것을 저장
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint"))); // 요청 파라미터값 읽어온 것을 저장
						
		
		int n = memberDao.insertMember(vo);
		
		System.out.println(n + "명의 회원 추가"); 
		

		resp.sendRedirect(req.getContextPath()+ "/member/list.do");
		
}
	}
}
