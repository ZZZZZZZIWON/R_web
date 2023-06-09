<%@page import="com.exam.member.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.member.MemberDaoBatis"%>
<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%!private MemberDao memberDao = new MemberDaoBatis();%>
<%
List<MemberVo> list = memberDao.selectMemberList();
request.setAttribute("memberList", list);
%>

<html>
<!DOCTYPE html>
<head>
<title>회원관리</title>
<meta charset=\"UTF-8\">
<script src="https://code.jquery.com/jquery-Latest.min.js"></script>
<style>

table {
	padding: 10px;
	width: 100%;

	border-collapse: collapse;
	margin: 0 auto;
}

th, td {
	padding: 5px;
	text-align:center;
}

#btn-del {
	margin-top: 5px margin-left:20px
}
div {
	margin:0 auto;
	width:500px;
	text-align:center;
}
.body {
	margin: 0 auto;
	width: 500px;
	text-align: center;
	border: 1px solid #aaa;
    border-radius: 30px;
    padding:10px;
}
</style>
</head>
<body>
	<div class="body">
	<h1>회원목록</h1>

	<table>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>포인트</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="vo" items="${memberList}">
			<tr>
			<td><c:out value="${vo.memId}"/></td>
			<td>${vo.memPass}</td>
			<td><c:out value="${vo.memName}"/></td>
			<td>${vo.memPoint }</td>
			<td><a href='${pageContext.request.contextPath}/member/memDel.jsp?memId=<c:out value="${vo.memId}"/>'>
				<c:url value="/member/memDel.jsp" var="delUrl">
					<c:param name="memId">${vo.memId}</c:param>
				</c:url>
				<a href='${delUrl}' class='btn-del'><button type='button'>삭제</button></a>
		</tr>
		</c:forEach>
		
	</table>
	<a href='<c:url value="/member/memAddForm.jsp"/>' class='btn-reg'><button type='button' >회원추가</button></a>
	</div>
	<script>
		$(document).ready(function(){
			$(".btn-del").click(function(){
				if(!confirm("삭제하시겠습니까?")){
					return false;
				}
			});
		});
	</script>
</body>
</html>
