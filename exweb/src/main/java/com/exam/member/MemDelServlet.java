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

//웹브라우저에서
// http://localhost:8000/exweb/member/del.do?memId=삭제할회원아이디
//로 요청을 보내면, 지정한 회원정보를 데이터베이스에서 사가제하고
// "몇 명의 회원 삭제 성공" 메시지와 "회원목록으로 이동"링크를 화면에 출력

@WebServlet("/member/del.do")
public class MemDelServlet extends HttpServlet {
	private MemberDao memberDao = new MemberDaoBatis();
//	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 서버 주소
//	String user = "web"; // 데이터베이스 접속 아이디
//	String password = "web01"; // 데이터베이스 접속 비밀번호

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8"); 필터로 이동

//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
		
		String memId = req.getParameter("memId"); // 컬럼이 늘어나도 상관 없기 때문에 객체에 담을 필요 X
		
		int n = memberDao.deleteMember(memId);
		
		System.out.println(n + "명의 회원 삭제");
		
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
//		out.println("<h2>"+ n + "명의 회원 삭제 성공</h2>");
//		out.println("<a href='" + req.getContextPath() + "/member/list.do'><button type='button'>회원목록</button></a>                ");
//		//out.println("<button onclick='location.href='" + req.getContextPath() + "/member/list.do''>회원목록</button>                ");
//		out.println("</body>                  ");
//		out.println("</html>                  ");
	}

//	public int deleteMember(String memId) {
//		String sql = "DELETE FROM MEMBER WHERE MEM_ID = ?"; // ★★★★★★★ 
//		// 넣을 값을 ?로 표현
//		// SQL문에는 세미콜론, 작은 따옴표 붙이지 x
//																											
//		// try () 내부에 선언된 변수의 값은
//		// try-catch 블럭의 실행이 완료된 후 자동으로 close() 메서드 실행
//		
//		int n=0;
//		try (
//
//				// 지정한 데이터베이스에 접속(로그인)
//				Connection conn = DriverManager.getConnection(url, user, password);
//				// 해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		) {
//
//			// pstmt 명령문 객체에 담겨 있는 SQL문의 ?에 값을 넣기
//			// 채워넣는 값의 타입에 따라서 set타입명() 메서드 사용
//			pstmt.setString(1, memId); // 1번째 ?에 memId 값을 넣기
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
