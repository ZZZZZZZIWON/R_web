package com.exam.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// MemberDaoBatis 안에서 mybatis를 이용해서 SQL문을 편하게 실행 가능
// 더는 사용하지 X
public class MemberDaoJdbc implements MemberDao { // DAO = DATA ACCESS OBJECT
						 // DB테이블에 있는 데이터를 자바 객체(MemberDao)에 담아서 반환
						 
					     // DAO클래스를 따로 관리하는 이유
						 // 1. 데이터베이스의 종류가 바뀔 때 Dao클래스만 변경 가능
						 // 2. 키보드로 입력 받는 어플리케이션으로 바꿀 때 DB는 그대로 둠

	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 서버 주소
	String user = "web"; // 데이터베이스 접속 아이디
	String password = "web01"; // 데이터베이스 접속 비밀번호

	// MemListServlet에서 사용
	@Override // MemberDao interface에 있는 method를 재정의
	public List<MemberVo> selectMemberList() { 
		//[데이터베이스 관련 코드 분리]
		 List<MemberVo> list = new ArrayList<MemberVo>(); 
		// 배열 한 칸에 저장할 타입을 <> 안에 지정(MemberVo클래스 하나씩_회원 정보 1개씩)
		// ArrayList뿐만 아니라 모든 타입의 list들 보관 가능
		 
		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER ORDER BY mem_id";

		try (

				// 지정한 데이터베이스에 접속(로그인)
				Connection conn = DriverManager.getConnection(url, user, password);
				// 해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			// SQL문 실행 (SELECT문 실행은 executeQuery() 메서드 사용
			
			ResultSet rs = pstmt.executeQuery(); // 반환값은 조회 결과 레코드(row) 수

			// .next()메서드는 다음 레코드가 있으면 true를 반환, 없으면 fail을 반환
			while (rs.next()) {
				MemberVo vo = new MemberVo();  //1개의 객체를 생성해야 1명의 회원의 정보를 저장 가능
				// 화면을 출력하는 html부분과 db관련된 부분을 분리시킬 필요 O
				vo.setMemId(rs.getString("mem_id")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
				vo.setMemPass(rs.getString("mem_pass")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
				vo.setMemName(rs.getString("mem_name")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
				vo.setMemPoint(rs.getInt("mem_point")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
				list.add(vo);
				// 회원 수만큼 list에 회원 정보 저장
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	// MemAddServlet에서 사용
	@Override
	public int insertMember(MemberVo vo) { // 요청 파라미터를 vo에 담아서 전달(안에 세부 사항들이 늘어나도 복잡해지지 않음)
		String sql = "INSERT INTO MEMBER( MEM_ID, MEM_PASS, MEM_NAME, MEM_POINT) " + "VALUES(?, ?, ?, ?)"; // ★★★★★★★
		// 넣을 값을 ?로 표현s
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
			pstmt.setString(1, vo.getMemId()); // 1번째 ?에 memId 값을 넣기
			pstmt.setString(2, vo.getMemPass()); // 2번째 ?에 memPass 값을 넣기
			pstmt.setString(3, vo.getMemName()); // 3번째 ?에 memName 값을 넣기
			pstmt.setInt(4, vo.getMemPoint()); // 4번째 ?에 memPoint 값을 넣기
			// SQL문 실행 (INSERT, UPDATE, DELETE 문 실행은 executeUpdate() 메서드 사용
			 // 반환값은 SQL문 실행으로 영향받은 레코드(row) 수
			n = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	// MemDelServlet에서 사용
	@Override
	public int deleteMember(String memId) {
		String sql = "DELETE FROM MEMBER WHERE MEM_ID = ?"; // ★★★★★★★ 
		// 넣을 값을 ?로 표현
		// SQL문에는 세미콜론, 작은 따옴표 붙이지 x
																											
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
			pstmt.setString(1, memId); // 1번째 ?에 memId 값을 넣기
			// SQL문 실행 (INSERT, UPDATE, DELETE 문 실행은 executeUpdate() 메서드 사용
			 // 반환값은 SQL문 실행으로 영향받은 레코드(row) 수
			n = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
}
