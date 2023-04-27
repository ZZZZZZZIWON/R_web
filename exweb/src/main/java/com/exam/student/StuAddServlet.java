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

@WebServlet("/student/add.do")
public class StuAddServlet extends HttpServlet {

	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}   // 객체가 만들어졌을때 최초로 1번 실행
		// 실행을 하면 회원 정보를 추가할 수 있도록 코드 구현
		// 애플리케이션에 JDBC 사용 전 최초 1번은 JDBC 드라이버 클래스를 메모리에 로드 필요

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		String stuId = req.getParameter("stuId");
		String stuName = req.getParameter("stuName");
		String stuScore = req.getParameter("stuScore");
		
		int score  = Integer.parseInt(stuScore);
		 
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 서버 주소
		String user = "web"; // 데이터베이스 접속 아이디
		String password = "web01"; // 데이터베이스 접속 비밀번호

		String sql = "INSERT INTO STUDENT( STU_NO, STU_NAME, STU_SCORE) " + "VALUES(?, ?, ?)"; // ★★★★★★★
		// 넣을 값을 ?로 표현
		// SQL문에는 세미콜론 붙이지 x
																											
		// try () 내부에 선언된 변수의 값은
		// try-catch 블럭의 실행이 완료된 후 자동으로 close() 메서드 실행
		
		int n=0;
		try (

				// 지정한 데이터베이스에 접속(로그인)
				Connection conn = DriverManager.getConnection(url, user, password);
				// 해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {

			// pstmt 명령문 객체에 담겨 있는 SQL문의 ?에 값을 넣기
			// 채워넣는 값의 타입에 따라서 set타입명() 메서드 사용
			pstmt.setString(1, stuId); // 1번째 ?에 memId 값을 넣기
			pstmt.setString(2, stuName); // 3번째 ?에 memName 값을 넣기
			pstmt.setInt(3, score); // 4번째 ?에 memPoint 값을 넣기
			// SQL문 실행 (INSERT, UPDATE, DELETE 문 실행은 executeUpdate() 메서드 사용
			 // 반환값은 SQL문 실행으로 영향받은 레코드(row) 수
			n = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>                   ");
		out.println("<!DOCTYPE html>          ");
		out.println("<head>                   ");
		out.println("<meta charset=\"UTF-8\"> ");
		out.println("<title>Param</title>     ");
		out.println("</head>                  ");
		out.println("<body>                   ");
		out.println("<h1>"+ n + "명의 학생 등록 성공</h>");
		out.println("</body>                  ");
		out.println("</html>                  ");
	}
}
