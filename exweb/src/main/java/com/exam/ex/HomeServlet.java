package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// SaveServlet에 저장된 데이터를 꺼내 사용하는 서블릿

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>HOME</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>HOME</h1>");

		// SaveServlet에서 저장한 데이터를 읽어서 출력 (Session)
		HttpSession session = req.getSession();
		String nickName = (String) session.getAttribute("nick");
		out.println("<h3>세션에 저장된 닉네임 : " + nickName + "<br>");
		// 세션 객체에 "nick"이라는 이름으로 저장된 데이터 읽기
		// 받아들이는 값이 어떤 데이터타입인지 확신 X -> Object
		// String으로 받아온 값을 저장하기 위해 형변환해서 String에 저장

		// SaveServlet에서 저장한 데이터를 읽어서 출력 (Servlet Context)
		ServletContext context = getServletContext();
		String contextNick = (String) context.getAttribute("nick");
		out.println("서블릿컨텍스트에 저장된 닉네임 : " + contextNick + "<br>");
		// 서블릿컨텍스트 객체에 "nick"이라는 이름으로 저장된 데이터 읽기

		// 요청 헤더(Cookie)에 포함된 쿠키 값들을 읽기
		Cookie[] cookies = req.getCookies();
		for (Cookie c : cookies) { // 쿠키들을 하나씩 확인하면서
			if ("nick".equals(c.getName())) { // 쿠키 이름이 "nick"인 경우
				String v = URLDecoder.decode(c.getValue(), "utf-8");
				out.println("쿠키에 저장된 닉네임 : " + v + "<br>");
			}
		}

		out.println("</h3>                  ");
		out.println("</body>                  ");
		out.println("</html>                  ");

	}
}
