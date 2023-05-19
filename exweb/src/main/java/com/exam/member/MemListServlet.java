package com.exam.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원목록 화면에 "회원추가" 링크를 추가하고, 
// 그 링크를 클릭하면, 회원정보를 입력하는 폼(/add.form.do) 화면으로 이동하도록
// MemListServlet 클래스를 변경하세요.

// 회원정보 추가 후에 "회원목록으로 이동" 링크를 추가하고, 
// 그 링크를 클릭하면, 회원목록 화면(/add.list.do)으로 이동하도록
// MemAddServlet 클래스를 변경하세요.


//회원목록의 각 회원정보 옆에 "삭제"링크를 출력하고,
//링크를 클릭하면 해당 회원이 삭제되도록 
//MemListServlet

//삭제 링크는 버튼으로
@WebServlet("/member/list.do")
public class MemListServlet extends HttpServlet {
	private MemberDao memberDao = new MemberDaoBatis(); // service 안에 있으면 계속 요청 but, 한번만 실행하면 됨
															// 인터페이스를 사용했기 때문에 MemberDao는 바꿀 필요 X

//	{
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}  add랑 list 둘 중에 어떤 서블릿이 먼저 실행될 지 불확실 ->

//	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 서버 주소
//	String user = "web"; // 데이터베이스 접속 아이디
//	String password = "web01"; // 데이터베이스 접속 비밀번호

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 자바 내에서 html을 사용하기 힘들기 때문에
		// html 안에서 자바를 사용하기로 함 -> jsp
		List<MemberVo> list = memberDao.selectMemberList(); // 이 DB관련 method를 실행시키는 코드

		req.setAttribute("memberList", list);
		req.getRequestDispatcher("/WEB-INF/views/member/memList.jsp").forward(req, resp);
		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//
//		out.println("<html>                   ");
//		out.println("<!DOCTYPE html>          ");
//		out.println("<head>                   ");
//		out.println("<meta charset=\"UTF-8\"> ");
//		out.println("<title>회원관리</title>     ");
//		out.println("<style>");
//		out.println("table {padding:10px width:100% border-top:1px solid #444444 border-collapse: collapse}");
//		out.println("th, td {padding:10px border-bottom:1px solid #444444 border-left:1px solid #444444}");
//		out.println("button {margin-top:5px");
//		out.println("margin-left:20px}");
//		out.println("</style>                  ");
//		out.println("</head>                  ");
//		out.println("<body>                   ");
//		out.println("<h1>회원목록</h1>                ");
//		//out.println("<input type ='button' value='회원가입' onclick='window.open('http://localhost:8000/exweb/member/addform.do')'>");
//		//out.println("<button type = 'button' onclick='window.open('http://localhost:8000/exweb/member/addform.do')'>회원가입</button> ");
//		//out.println("<a href='http://localhost:8000/exweb/member/addform.do'>회원추가</a>");
//
//		out.println("<table><tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>포인트</th><th>삭제</th></tr>");
//		// list에 있는 회원 정보를 하나씩 꺼냄
//		for (MemberVo vo : list) {
//			out.println("<tr><td>" + vo.getMemId()+"</td><td>" + vo.getMemPass() + "</td><td>" + vo.getMemName() + "</td><td>" + vo.getMemPoint() + "</td>");
////			out.println("<p>" + vo.getMemId() + " : " + vo.getMemPass() + " : " + vo.getMemName() + " : " + vo.getMemPoint());
//			out.println("<td><a href='" + req.getContextPath() + "/member/del.do?memId=" + vo.getMemId() + "'><button type = 'button'>삭제</button></a></td></tr>");
////			out.println("</p>");
//		
//		}
////		out.println("<button type=\"button\" onclick=\"location.href='" + req.getContextPath() + "/member/list.do'\">회원목록</button> ");
////		  out.println("<form method=\"POST\" name=\"form\">");
////	        out.println("<button type=\"button\" onclick=\"location.href='" + req.getContextPath() + "/member/list.do\">회원목록</button>");
////	    </form>
//		
//		// 밑에 출력하는 부분을 밖으로 빼려면 while문 안에 있는 변수를 받을 수 있어야 함(에러)
//		// So, 단일변수에 저장하는 것이 아니라 List에 저장해놔야 함
//		// memId, memPass, memName, memPoint(문자열, 문자열, 문자열, 정수)를 한 번에 저장할 수 있어야 함 -> 객체 생성
//		// 클래스를 정의하는 이유 1 현실에 존재하는 사물을 객체로 생성 2 원하는 데이터 타입으로 저장
//		// 보통 member정보를 Member or MemberVO or MemberDTO라는 클래스에 저장
//		out.println("</table>");
//		out.println("<a href='" + req.getContextPath() + "/member/addform.do'><button type='button'>회원추가</button></a>                ");
//		out.println("</body> </html>                  ");
//
//	}

//	public List<MemberVo> selectMemberList() { 
//		//[데이터베이스 관련 코드 분리]
//		 List<MemberVo> list = new ArrayList<MemberVo>(); 
//		// 배열 한 칸에 저장할 타입을 <> 안에 지정(MemberVo클래스 하나씩_회원 정보 1개씩)
//		// ArrayList뿐만 아니라 모든 타입의 list들 보관 가능
//		 
//		String sql = "SELECT mem_id, mem_pass, mem_name, mem_point FROM MEMBER ORDER BY mem_id";
//
//		try (
//
//				// 지정한 데이터베이스에 접속(로그인)
//				Connection conn = DriverManager.getConnection(url, user, password);
//				// 해당 연결을 통해 실행할 SQL문을 담은 명령문 객체 생성
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//
//		) {
//			// SQL문 실행 (SELECT문 실행은 executeQuery() 메서드 사용
//			
//			ResultSet rs = pstmt.executeQuery(); // 반환값은 조회 결과 레코드(row) 수
//
//			// .next()메서드는 다음 레코드가 있으면 true를 반환, 없으면 fail을 반환
//			while (rs.next()) {
//				MemberVo vo = new MemberVo();  //1개의 객체를 생성해야 1명의 회원의 정보를 저장 가능
//				// 화면을 출력하는 html부분과 db관련된 부분을 분리시킬 필요 O
//				vo.setMemId(rs.getString("mem_id")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
//				vo.setMemPass(rs.getString("mem_pass")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
//				vo.setMemName(rs.getString("mem_name")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
//				vo.setMemPoint(rs.getInt("mem_point")); // 현재 가리키는 레코드(row)의 "mem_id"의 컬럼값 알기
//				list.add(vo);
//				// 회원 수만큼 list에 회원 정보 저장
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
}
}
