package com.exam.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿은 일반적으로 HttpServlet 클래스를 상속(확장)하여 구현
//서블릿 맵핑 : 어떤 경로로 요청이 왔을 때 서블릿을 실행시키고 싶은지
// 요청경로와 서블릿을 연결

//서블릿 맵핑 방법
// (1) web.xml 파일에 <servlet><servlet-mapping>태그를 사용하여 설정
   //-다른 사람이 보내준 class파일에는 @를 붙일 수 없어서 이 방법을 사용
// (2)서블릿 클래스에 @WebServlet("요청주소") 를 적용

@WebServlet("/hello.do") //"hello.do" 파일을 달라는 요청이 오면 이 서블릿 클래스를 실행하라
                         //파일의 경로
public class HelloServlet extends HttpServlet {

	//클라이언트(웹브라우저)의 요청을 받아서 서블릿이 실행될 때마다
	//서블릿의 service() 메소드가 한번씩 실행
	
	//톰캣이 service() 메서드 실행시에 인자로 요청객체와 응답객체를 전달
			//요청객체(HttpServletRequest) 
			//: 클라이언트(웹브라우저)가 보낸 요청에 대한 모든 정보를 담고 있는 객체
			//응답객체(HttpServletResponse) 
			//: 요청에 대한 응답으로 클라이언트(웹브라우저)에게 전송할 모든 정보를 담는 객체
			
	@Override //컴퓨터에게 제공하는 주석
				//-상속받은 것을 덮어씌우는 것
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet 실행!");
		//요청주소 뒤에 "? 파라미터명=파라미터값 & 파라미터명=파라미터값 &..."
		//의 형태로 추가로 전달랄 파라미터들을 지정 가능
		//서블릿에서는 요청객체.getParameter("파라미터명") 명령문으로
		//원하는 파라미터의 값을 사용 가능
		String aval = req.getParameter("성");
		String bval = req.getParameter("이름");
		
		
		resp.setCharacterEncoding("UTF-8");//응답내용을 쓸 때 사용할 문자인코딩 방식 지정(writer전에 설정)
		resp.setContentType("text/html");//응답내용의 데이터타입을 설정(ex_이미지, 영상, 오디오파일 등)-웹 브라우저에게 정보 제공
//		resp.setContentType("text/html; charset=UTF-8");//문자인코딩과 데이터타입을 한번에 설정 가능
		PrintWriter out = resp.getWriter(); //응답객체에 내용을 쓸 수 있는 writer 가져오기
		/* out.println("Hello SERVLET"); *///응답객체에 문자열을 출력    //(출력용 파이프)
		//응답객체에 출력한 내용은 클라이언트(웹브라우저)로 전송됨
		// html, css로 스타일 지정
		
		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");  //1) 작은따옴포를 쓰거나, 2)\붙여서 escape하기 ("를 문자라고 지정)
		out.println("<title>HELLO</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>서블릿이 출력한 HTML</h1>");
		out.println("<h2>성 : " + aval + "</h2>");
		out.println("<h2>이름 : " + bval + "</h2>");
		out.println("</body>                  ");
		out.println("</html>                  ");
	
	}
}
