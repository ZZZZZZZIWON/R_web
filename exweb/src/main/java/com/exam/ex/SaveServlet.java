package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// ■ 다수의 서블릿들이 공유하는 데이터를 저장하는 공간
// 1. 서버(톰캣)
//	(1) 요청 객체 (=> HttpServletResquest req)
//		- 요청 1개마다 1개의 요청 객체 생성, 요청 처리가 끝나면 소멸
//		- 하나의 요청을 처리하기 위해 사용되는 서블릿들간의 데이터 공유 (forward, include)
//		- forward, include시 요청과 응답 객체를 전달 -> 다른 서블릿에서 사용 가능(예외)
//	(2) 세션 객체
//		- 클라이언트(웹브라우저) 1개당 1개의 세션 객체 생성
//		- 클라이언트, 서버 종류시 또는 일정시간동안 요청이 없을 때 세션 객체 소멸
//		- 클라이언트(사용자, 웹브라우저)별로 각각 유지해야하는 데이터 공유
//	(3) 서블릿컨텍스트 객체
//		- 웹 애플리케이션 전체에서 1개의 서블릿컨텍스트 객체만 생성
//		- 서버(톰캣)이 시작될 때 생성, 서버가 종료될 때 소멸
//		- 모든 사용자와 모든 서블릿들이 데이터 공유

//	* 요청 객체, 세션 객체, 서블릿컨텍스트 객체 모두 동일한 메서드로 데이터 저장 및 조회
//		- 객체.setAttribute("속성명", 속성값) : 속성값 저장
//		- 객체.getAttribute("속성명", 속성값) : 속성값 읽기
//		- 객체.removeAttribute("속성명", 속성값) : 속성 삭제

// 2. 클라이언트(웹브라우저)에 저장
//  (1) 쿠키
//		- 웹브라우저에 데이터를 이름-값 쌍으로 저장
//		- 기본적으로 쿠키를 저장한 웹사이트(도메인)와 동일한 웹사이트로 요청을 보낼 때
//		  요청 헤더에 쿠키를 자동으로 포함(변경 가능)
//		- 만료기간을 설정하면, 웹브라우저가 종료되더라도 쿠키 값 유지 가능
// 		- 웹브라우저에서 접근하여 사용 가능하기 때문에 보안상 위험 존재
//   	- 보안이 필요한 정보는 쿠키에 저장 XXX
//		- 쿠키의 이름과 값은 쉼표, 세미콜론, 공백 등 특수문자와 한글 등 비영어권 문자 사용 불가
//		- 일반적으로 쿠키이름은 영문자와 숫자만 사용, 쿠키값은 인코딩/디코딩하여 사용
	      
//	(2) HTML5에서는 sessionStorage, localStorage, indexedDB도 사용 가능

@WebServlet("/save") 
public class SaveServlet extends HttpServlet {

			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nval = req.getParameter("nn");
		String rval = req.getParameter("rem");
		
		// 현재 요청을 보낸 사용자의 세션 객체 가져오기 (없으면 생성)
		HttpSession session = req.getSession();
		session.setAttribute("nick", nval); // 세션 객체에 "nick"이라는 이름으로 nval 변수값을 저장 
							// 속성이름, 속성값 -> session.getAttribute("nick");
		
		// 현재 웹 애플리케이션의 서블릿컨텍스트 객체 가져오기
		ServletContext context = getServletContext();
		context.setAttribute("nick", nval); // 서블릿컨텍스트 객체에 "nick"이라는 이름으로 nval 변수값을 저장 
		
		if("on".equals(rval)) {
			String enval = URLEncoder.encode(rval, "utf-8"); // 한글, 특수문자 포함시 인코딩 필요
			Cookie c = new Cookie("nick", enval); // 데이터 이름-값을 담은 쿠키 생성
			
			c.setMaxAge(60*5); // 쿠키 유효기간(초) 설정 (0 => 즉시 삭제, 음수 => 웹브라우저 종료시 삭제)
//			c.setDomain("도메인"); // 지정한 도메인과 하위 도메인으로 요청을 전송할 때만 쿠키 포함
//			c.setPath("경로"); // 지정한 경로의 하위 경로로 요청을 전송할 때만 쿠키 포함
//			c.setHttpOnly(true); // true로 설정하면 자바스크립트로 쿠키 접근 불가(기본값은 false)
//			c.setSecure(true); // true로 설정하면 https://와 같은 보안 프로토콜 사용시에만 쿠키 포함
			
			
			resp.addCookie(c); // 웹브라우저가 쿠키를 저장하도록 응답에 포함
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter(); 
	
		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");  
		out.println("<title>SAVE</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>SAVE SESSION</h1>");

		out.println("</body>                  ");
		out.println("</html>                  ");

	}
}
