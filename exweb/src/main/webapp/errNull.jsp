<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
<style>
html, body {
    margin: 0;
    padding: 0;
    height: 100%;
  }
  
  img {
    display: block;
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
</style>
</head>
<body>
	<h2>발생한 예외 객체 : <%=exception %></h2>
	<%-- <h2>발생한 예외 객체 : ${pageContext.exception}</h2>	 --%>
	<img alt="ERROR" src="${pageContext.request.contextPath}/img/500.jpg">

</body>
</html>