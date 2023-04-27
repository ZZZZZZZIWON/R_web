package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;

@WebServlet("/calc.do")
public class CalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		String xval = req.getParameter("x");
		String yval = req.getParameter("y");
		String opval = req.getParameter("op");

		double xnum = Double.parseDouble(xval); // 실수 문자열을 실수로 변환
		double ynum = Double.parseDouble(yval);
		// 숫자타입클래스명.parse 숫자타입명("숫자문자열")

		/*
		 * Integer.parseInt("123") = 123 Float.parseFloat("123.456") = 123.456
		 * Double.parseDouble("123.456") = 123.456
		 */
		double result =0; //4가지 연산 중에서 아무것도 안 하면 실행이 안되기 때문에 초기값을 넣어주어야 함 
		String operator="";
		
		// op 파라미터값에 맞는 사칙연산을 수행
		// 문자열 값을 동등비교하는 경우, ==연산자가 아닌 .equals() 메서드 사용
		/* * "문자열1" == "문자열2" (x) "문자열1".equals("문자열2")(o) */
		switch (opval) {
		case "plus":
			 result = xnum + ynum;
			 operator = "+";
			break;
		case "minus":
			 result = xnum - ynum;
			 operator = "-";
			break;
		case "mul":
			 result = xnum * ynum;
			 operator = "*";
			break;
		case "div":
			 result = xnum / ynum;
			 operator = "/";
			break;
		} //result변수는 가장 가까운 중괄호인 위쪽에서만 실행 가능

		PrintWriter out = resp.getWriter();

		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>Calculater</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>"+ xval
				+ operator + yval + "=" + result + "</h1>");
		out.println("</body>                  ");
		out.println("</html>                  ");
	}
}