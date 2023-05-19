<%@page import="com.exam.member.MemberDaoBatis"%>
<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!private MemberDao memberDao = new MemberDaoBatis();%>

<%
String memId = request.getParameter("memId"); 

int n = memberDao.deleteMember(memId);

System.out.println(n + "명의 회원 삭제");

response.sendRedirect(request.getContextPath() + "/member/memList.jsp");
%>