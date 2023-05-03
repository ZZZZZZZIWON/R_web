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

@WebServlet("/student/del.do")
public class StuDelServlet extends HttpServlet {
	private StudentDao studentDao = new StudentDaoBatis();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String stuNo = req.getParameter("stuNo"); // 컬럼이 늘어나도 상관 없기 때문에 객체에 담을 필요 X
		
		int n = studentDao.deleteStudent(stuNo);
		
		System.out.println(n + "명의 회원 삭제");
		
		resp.sendRedirect(req.getContextPath()+ "/student/list.do");
	}
}
