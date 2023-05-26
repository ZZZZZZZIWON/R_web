<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
button { display:inline-block; }
p { display:inline-block; }

</style>
</head>
<body>
<c:if test="${loginUser!=null }"> 
<p>로그인 계정 : ${loginUser.memId}</p>
<a href='${pageContext.request.contextPath}/member/logout.do'><button type='button' >로그아웃</button></a>
</c:if>

<c:if test="${loginUser==null}"> 

<a href='${pageContext.request.contextPath}/member/login.do'><button type='button' >로그인</button></a>
<a href='${pageContext.request.contextPath}/member/add.do'><button type='button' >회원추가</button></a>
</c:if>
</body>
</html>