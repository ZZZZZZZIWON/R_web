package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/addform.do")
public class StuAddFormServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>학생관리</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>학생등록</h1>"); //req.getContextPath() = "/exweb" 일일히 바꿀 필요 X
										// /exweb/ 경로는 중복이지만 종종 바꾸기 때문에 명령어로 따로 관리		
		out.println("<form action='" + req.getContextPath() + "/student/add.do' method='post'/>"); // get방식일 경우 value값 그대로 반환(인코딩 영향 없음)
		out.println("ID 	  : <input type='text' name='stuNo' value=''><br/>");
		out.println("NAME 	  : <input type='text' name='stuName' value=''/><br/>");
		out.println("SCORE    :  <input type='number' name='stuScore' value='0'><br/>");
		out.println("<input type='submit'>");
		out.println("</form>");
		out.println("</body>                  ");
		out.println("</html>                  ");
	}
}

