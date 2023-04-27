package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ByeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("Bye Bye");
	}
}

//1.웹브라우저에서 http://localhost:8000/exweb/bye.do로 접속하면,
//  웹브라우저 화면에 "Bye Bye"라고 출력되도록 ByeServlet 클래스를 변경하세요.

//2. 웹브라우저에서 http://localhost:8000/exweb/foo/bar.do로 접속하면,
//   웹브라우저 화면에 "Welcome"이라고 출력되도록 HiServlet 클래스를 새로 추가하세요.
