<%@page import="com.exam.member.MemberVo"%>
<%@page import="java.util.List"%>
<%@page import="com.exam.member.MemberDaoBatis"%>
<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!DOCTYPE html>
<head>
<meta charset=\"UTF-8\">
<title>회원관리</title>
<style>
div {
	
}
.body {
	margin: 0 auto;
	width: 500px;
	text-align: center;
	border: 1px solid #aaa;
    border-radius: 30px;
}

.form {
	margin:0 auto;
}

.form label {
	display: inline-block;
	width: 100px;
	text-align: left;
}

.form input {
	display: inline-block;
	margin-bottom: 10px;
}
.form #login {
	float:right;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<hr>
	<div class="body">
	<h1>회원변경</h1>
	<form action='${pageContext.request.contextPath}/member/edit.do' method='post' />
	<div class="form">
				<label for="memId">ID :</label>
				<input type='text' name='memId' id="memId" value='<c:out value="${mvo.memId}"/>' readonly="readonly"><br />

				<label for="memPass">PASSWORD :</label>
				<input type='password' name='memPass' id="memPass" value='<c:out value="${mvo.memPass}"/>'><br />

				<label for="memName">NAME :</label>
				<input type='text' name='memName' id="memName" value='<c:out value="${mvo.memName}"/>'><br />

				<label for="memPoint">POINT :</label>
				<input type='number' name='memPoint' id="memPoint" value='${mvo.memPoint}'><br />
			</div>
	<input type='submit' value="수정">
	</form>
	</div>
</body>
</html>
