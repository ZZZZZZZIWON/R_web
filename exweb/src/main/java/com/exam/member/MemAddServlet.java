package com.exam.member;

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

@WebServlet("/member/add.do")
public class MemAddServlet extends HttpServlet {
	
	private MemberDao memberDao = new MemberDaoBatis();
//	{
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}   
	     // 객체가 만들어졌을때 최초로 1번 실행
		// 실행을 하면 회원 정보를 추가할 수 있도록 코드 구현
		// 애플리케이션에 JDBC 사용 전 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요
//	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 서버 주소
//	String user = "web"; // 데이터베이스 접속 아이디
//	String password = "web01"; // 데이터베이스 접속 비밀번호
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");  필터로 이동
		// 주석 처리가 되었기 때문에 post방식의 한글 파라미터가 전송 X

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		// ? 파라미터를 따로 관리하는 것보다 하나의 객체에서 관리해야 효율적
		MemberVo vo = new MemberVo(); // 파라미터의 갯수를 1개로 유지
		vo.setMemId(req.getParameter("memId")); // 요청 파라미터값 읽어온 것을 저장
		vo.setMemPass(req.getParameter("memPass")); // 요청 파라미터값 읽어온 것을 저장
		vo.setMemName(req.getParameter("memName")); // 요청 파라미터값 읽어온 것을 저장
		vo.setMemPoint(Integer.parseInt(req.getParameter("memPoint"))); // 요청 파라미터값 읽어온 것을 저장
						
		
		int n = memberDao.insertMember(vo);
		
		System.out.println(n + "명의 회원 추가"); // n 변수를 사용하는 코드가 있어야 return값으로 n을 반환할 수 있음
		
		// When) 다른 서블릿을 실행하고 싶을 때!!
		// 회원목록 출력
		// MemListServlet 실행!
		// forward : 요청객체와 응답객체를 전달하면서 다른 서블릿을 실행
		//  	현재 서블릿에서는 더 이상 응답을 출력하지 않는다
		//req.getRequestDispatcher("/member/list.do").forward(req, resp); // 이동할 주소 입력

		//include : 요청객체와 응답객체를 전달하면서 다른 서블릿을 실행
		//		현재 서블릿의 출력 내용 중간에 지정한 서블릿의 출력 내용을 포함
		// 		다른 서블릿 실행 후 돌아와서 다음에 다른 내용을 출력할 것이 있을 때 사용
		//req.getRequestDispatcher("/member/list.do").include(req, resp); 
		
		//redirect : 지정한 주소로 이동하라는 명령을 담은 응답을 웹브라우저에게 전송
		resp.sendRedirect(req.getContextPath()+ "/member/list.do");
		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		
//		PrintWriter out = resp.getWriter();
//		
//		out.println("<html>                   ");
//		out.println("<!DOCTYPE html>          ");
//		out.println("<head>                   ");
//		out.println("<meta charset=\"UTF-8\"> ");
//		out.println("<title>회원관리</title>     ");
//		out.println("</head>                  ");
//		out.println("<body>                   ");
//		//out.println("<a href='http://localhost:8000/exweb/member/list.do'>회원목록으로 이동</a>");
//		out.println("<a href='" + req.getContextPath() + "/member/list.do'>회원목록</a>                ");
//		out.println("<h2>"+ n + "명의 회원 추가 성공</h2>");
//		out.println("</body>                  ");
//		out.println("</html>                  ");
		
		
	}

//	public int insertMember(MemberVo vo) { // 요청 파라미터를 vo에 담아서 전달(안에 세부 사항들이 늘어나도 복잡해지지 않음)
//		String sql = "INSERT INTO MEMBER( MEM_ID, MEM_PASS, MEM_NAME, MEM_POINT) " + "VALUES(?, ?, ?, ?)"; // ★★★★★★★
//		// 넣을 값을 ?로 표현s
//		// SQL문에는 세미콜론 붙이지 x
//																											
//		// try () 내부에 선언된 변수의 값은
//		// try-catch 블럭의 실행이 완료된 후 자동으로 close() 메서드 실행
//		
//		int n=0;
//		try (
//				// 지정한 데이터베이스에 접속(로그인)
//				Connection conn = DriverManager.getConnection(url, user, password);
//				// 해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//		) {
//
//			// pstmt 명령문 객체에 담겨 있는 SQL문의 ?에 값을 넣기
//			// 채워넣는 값의 타입에 따라서 set타입명() 메서드 사용
//			pstmt.setString(1, vo.getMemId()); // 1번째 ?에 memId 값을 넣기
//			pstmt.setString(2, vo.getMemPass()); // 2번째 ?에 memPass 값을 넣기
//			pstmt.setString(3, vo.getMemName()); // 3번째 ?에 memName 값을 넣기
//			pstmt.setInt(4, vo.getMemPoint()); // 4번째 ?에 memPoint 값을 넣기
//			// SQL문 실행 (INSERT, UPDATE, DELETE 문 실행은 executeUpdate() 메서드 사용
//			 // 반환값은 SQL문 실행으로 영향받은 레코드(row) 수
//			n = pstmt.executeUpdate();
//
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return n;
//	}
}
