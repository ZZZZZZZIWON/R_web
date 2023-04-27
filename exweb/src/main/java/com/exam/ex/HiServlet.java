package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//서블릿 URL 패턴(주소,경로) 지정 규칙
//-"/" 또는 "*."으로 시작
//-"*"은 0개 이상의 모든 문자열과 일치
   //   /foo/*
   //   *.do

//"/hi.do?user=둘리"로 요청을 보내면, 화면에 "둘리님 환영합니다"라고 출력
//"/hi.do?user=고길동"으로 요청을 보내면, 화면에 "고길동님 환영합니다"라고 출력
//HiServlet의 내용을 변경하시오.
@WebServlet("/hi.do")
public class HiServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String xxx = req.getParameter("user");
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
//		out.println("Welcome!!");
		
		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("	<meta charset=\"UTF-8\"> ");  //1) 작은따옴표를 쓰거나, 
		out.println("	<title>HI</title>     "); 	  //2)\붙여서 escape하기 "를 문자라고 지정)
		
		out.println("<style>                  ");
		out.println("h2 {font-size:100px;}                  ");
		out.println("</style>                  ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("	<h2>"+ xxx +"님 환영합니다!!!!!!!!!!</h2>");
		out.println("</body>                  ");
		out.println("</html>                  ");
	}

}
//이클립스의 다이나믹웹프로젝트(톰캣)가 실행 중인 상태에서
// 1)*.java 파일을 변경하면, 이클립스가 톰캣을 자동 재시작함
// 2)src/main/webapp 폴더의 정적 리소스(*.html, *.css...)파일들을 변경하면
//즉시 톰캣에 반영되므로 톰캣 재시작 없이 웹브라우저에서 새로고침만 필요
//3)web.xml 등 설정파일 변경시에는 수동으로 톰캣 재시작 필요



