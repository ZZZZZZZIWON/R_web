package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 	@WebServlet("/param.do")
	public class ParamServlet extends HttpServlet {
		
		@Override
		protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//GET 방식으로 전송된 요청 파라미터값을 읽을 때 사용할 문자 인코딩 방식은
			//톰캣의 server.xml파일에 있는 <Connector port="8080" protocol="HTTP/1.1"> 태그에
			//URIEncoding = UTF-8 속성을 추가하여 지정 가능		
			
			req.setCharacterEncoding("UTF-8"); 
			//POST 방식으로 전송된 요청 파라미터값을 읽을 때 사용할 문자인코딩 방식 설정
			//파라미터 읽기 전에 설정할 것
			
			String a = req.getParameter("x");
			String b = req.getParameter("y");
			
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			
			PrintWriter out = resp.getWriter();
			
			out.println("<html>                   ");
			out.println("<!DOCTYPE html>          ");
			out.println("<head>                   ");
			out.println("<meta charset=\"UTF-8\"> ");
			out.println("<title>Param</title>     ");
			out.println("</head>                  ");
			out.println("<body>                   ");
			out.println("<h1>x 파라미터값 : "+a+"</h>");
			out.println("<h1>y 파라미터값 : "+b+"</h> ");
			out.println("</body>                  ");
			out.println("</html>                  ");
			
	}
}

//"/param.do?x=포로리 & y=너부리"로 요청을 보내면,
//화면에
//"x 파라미터값 : 포로리"
//"y 파라미터값 : 너부리"
 	