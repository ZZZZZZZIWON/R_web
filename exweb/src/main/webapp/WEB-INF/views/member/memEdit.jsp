<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	

<html>
<!DOCTYPE html>
<head>
<meta charset=\"UTF-8\">
<title>회원관리</title>
<style>
table {
	padding: 10px;
	width: 100%;

	border-collapse: collapse;
	margin: 0 auto;
}
th {
	border-bottom:1px solid #ccc;
}

th, td {
	padding: 5px;
	text-align:center;
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
	<div class="body">
	<h1>회원정보변경</h1>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>포인트</th>
			<th>삭제</th>
		</tr>
		
	
			<tr>
			<td><c:out value="${mvo.memId}"/></td>
			<td><c:out value="${mvo.memName}"/></td>
			<td>${mvo.memPoint}</td>
			<td><a href='${pageContext.request.contextPath}/member/del.do?memId=<c:out value="${mvo.memId}"/>'></a>
				<c:url value="/member/del.do" var="delUrl">
					<c:param name="memId">${mvo.memId}</c:param>
				</c:url>
				<a href='${delUrl}' class='btn-del'><button type='button'>삭제</button></a>
				</td>
		</tr>
	
		
	</table>
	</div>
</body>
</html>
