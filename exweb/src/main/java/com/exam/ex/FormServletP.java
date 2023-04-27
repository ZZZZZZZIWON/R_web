package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;
//http://eosin.mooo.com:8080/mod/quiz/view.php?id=12
//202309
//Kopo-2309
	
/*http://localhost:8000/exweb/dollar?num=10000&unit=dollar
  http://localhost:8000/exweb/dollar?num=10000&unit=won  */
@WebServlet("/formP.do")
public class FormServletP extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		String pval = req.getParameter("prod");
		String fval = req.getParameter("fruit");
		String[] dval = req.getParameterValues("drink"); 
		//get.ParameterName 내가 지정한 파라미터명들을 알고 싶을때
		//get.ParameterMap =key값과 value값을 연결해서 저장
		//getParameterValues = 파라미터값들이 여러개일때
		
		PrintWriter out = resp.getWriter();

		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>Calculater</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>요청주소 : "+req.getRequestURL()+"</h1> ");
		out.println("<h1>요청주소 : "+req.getRequestURI()+"</h1> ");
		out.println("<h1>애플리케이션 고유경로 : "+req.getContextPath()+"</h1> ");
		out.println("<h1>요청방식 : "+req.getMethod()+"</h1> ");
		out.println("<h1>User-Agent요청헤더 : "+req.getHeader("User-Agent")+"</h1> ");
		out.println("<h1>사용자IP주소 : "+req.getRemoteAddr()+"</h1> ");
		
		out.println("<h1>상품 : "+pval+"</h1> ");
		out.println("<img src='http://api.lorem.space/image/"+pval+"?w=150&h=150'/h1> ");		
		out.println("<h1>과일 : "+ fval +"</h1> ");
		out.println("<h1>음료 : ");
		
		if (dval != null) {

		for (int i = 0; i < dval.length; i++) 
			//dval값이 null인 경우 오류 발생
			//null이 아닐 때만 실행하게 하기
			out.println("[" + dval[i] + "]");
			}
		
			out.println("</h1>" );
			
//if)dval[i]값이 3이라면 --> out.println("[" + dval[0] + "]");
//							out.println("[" + dval[1] + "]");
//							out.println("[" + dval[2] + "]");
		
		out.println("</body>                  ");
		out.println("</html>                  ");
		}
	}
