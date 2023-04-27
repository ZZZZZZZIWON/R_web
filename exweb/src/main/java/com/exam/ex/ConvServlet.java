package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.SwitchStatement;

/*http://localhost:8000/exweb/dollar?num=10000&unit=dollar
  http://localhost:8000/exweb/dollar?num=10000&unit=won  */
@WebServlet("/dollar")
public class ConvServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		String numval = req.getParameter("num");
		String unitval = req.getParameter("unit"); // 글자니까 double형으로 변환할 필요 없음

		int fromMoney = Integer.parseInt(numval); // 실수 문자열을 실수로 변환
		int result = 0;
		String fromUnit = "";
		String toUnit = "";

		switch (unitval) {
		case "won":
			result = fromMoney / 1287;
			fromUnit = "원";
			toUnit = "달러";
			break;
		case "dollar":
			result = fromMoney * 1287;
			fromUnit = "달러";
			toUnit = "달러";
			break;
		}

		PrintWriter out = resp.getWriter();

		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>Calculater</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.printf("<h1>%d%s = %d%s</h1>",fromMoney, fromUnit, result, toUnit);
		out.println("</body>                  ");
		out.println("</html>                  ");
	}
}