package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/student/list.do")
public class StuListServlet extends HttpServlet {
	private StudentDao studentDao = new StudentDaoBatis();														// 인터페이스를 사용했기 때문에 MemberDao는 바꿀 필요 X


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<StudentVo> list = studentDao.selectStudentList(); // 이 DB관련 method를 실행시키는 코드

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>학생관리</title>     ");
		out.println("<style>");
		out.println("table {padding:10px width:100% border-top:1px solid #444444 border-collapse: collapse}");
		out.println("th, td {padding:10px border-bottom:1px solid #444444 border-left:1px solid #444444}");
		out.println("button {margin-top:5px");
		out.println("margin-left:20px}");
		out.println("</style>                  ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>학생목록</h1>                ");
		

		out.println("<table><tr><th>학번</th><th>이름</th><th>점수</th><th>삭제</th></tr>");
		for (StudentVo vo : list) {
			out.println("<tr><td>" + vo.getStuNo()+"</td><td>" + vo.getStuName() + "</td><td>" + vo.getStuScore() + "</td>");
			out.println("<td><a href='" + req.getContextPath() + "/student/del.do?stuNo=" + vo.getStuNo() + "'><button type = 'button'>삭제</button></a></td></tr>");
		
		}
		out.println("</table>");
		out.println("<a href='" + req.getContextPath() + "/student/addform.do'><button type='button'>학생등록</button></a>                ");
		out.println("</body> </html>                  ");

	}

}
