<%@page import="com.exam.member.MemberVo"%>
<%@page import="com.exam.member.MemberDaoBatis"%>
<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private MemberDao memberDao = new MemberDaoBatis();%>
<%
		MemberVo vo = new MemberVo();
		vo.setMemId(request.getParameter("memId")); 
		vo.setMemPass(request.getParameter("memPass")); 
		vo.setMemName(request.getParameter("memName")); 
		vo.setMemPoint(Integer.parseInt(request.getParameter("memPoint"))); 
						
		
		int n = memberDao.insertMember(vo);
		
		System.out.println(n + "명의 회원 추가"); 
		
	
		response.sendRedirect(request.getContextPath()+ "/member/memList.jsp");
%>