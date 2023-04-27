<%@page import="com.exam.member.MemberVo"%> <%-- 자바의 import문으로 표현 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" 
    pageEncoding="EUC-KR"%>
    <%-- contentType="text/html; charset=EUC-KR" <- setCharacterEncoding이랑 동일 --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP</title>
</head>
<body>
	<h1>HELLO JSP</h1>

<!-- HTML 주석 -->
<%-- JSP 주석 --%>
<%-- 
JSP 구성요소
- 디렉티브 : page(현재 JSP파일 전체에 대한 설정), include(다른 JSP파일 포함), taglib(태그 라이브러리 사용)
	<%@ 디렉티브명 속성명="속성값" %>
- 스크립트요소
	- 스트립트릿 : <% 서블릿의 service메서드 내부에 들어갈 자바 코드 %>
	- 표현식 : <%= 현재 위치에 결과값을 출력할 자바 코드 %>
	- 선언부 : <%! 서블릿의 service메서드 외부에 들어갈 자바 코드 %>
	- 주석 
(부가적으로 필요해서 만들어진 요소들)	
- 액션태그 : 자주 사용하는 자바 코드를 대체할 수 있는 태그(잘 사용 X)
- EL(표현언어)
- 커스텀태그
 --%>
 <%
 	// 변수 선언없이 사용가능한 내장객체(기본객체) :
 	// 자동완성해서 맨 위에 쓰는 것들(ex_ out) - 서블릿으로 변환할 때 자동으로 사용가능하게 해줌)
	// request(요청객체), response(응답객체) - 서블릿에서 인자로 주고 받던 객체들
	// session(세션객체), application(서블릿컨텍스트객체) - 브라우저마다 닉네임이 다르게 저장되던 객체들
	// out(응답출력스트림), config(서블릿설정), pageContext(현재 JSP파일에 대한 모든 정보를 담은 객체- 내장객체 전체를 담은 객체)
	// page(현재 JSP서블릿객체 자체), exception(발생한 예외 - 에러 처리용 JSP를 사용할 때 에러에 대한 정보를 담은 객체)	
 	out.println("<p>");
	out.println("출력할 내용");
 	out.println(session == request.getSession()); // true
 	out.println(application == getServletContext()); // true
 	out.println(config == getServletConfig()); // true
 	// 이미 변수에 담아놨기 때문에 이름만 호출해서 사용 가능
 	
 	// JSP에는 서버에 저장할 수 있는 게 하나 추가 -> pagecontext 
 	// pageContext 객체에 현재 JSP 파일에서만 사용가능한 데이터를 속성으로 저장 가능
 	pageContext.setAttribute("pa", "pv"); 
 	out.println(pageContext.getAttribute("pa")); 
 	// 웹에 저장하는 것처럼 저장 가능
 	// pageContext 객체에는 다른 내장 객체들이 모두 저장되어 있음(request, response, session, application, out, config, exception)
 	out.println(request==pageContext.getRequest());
 	out.println(response==pageContext.getResponse());
 	out.println(session==pageContext.getSession());
 	out.println(application==pageContext.getServletContext());
 	out.println("</p>");
 	// EL에서는 내장객체 이름에 직접 접근이 안됨 -> pageContext로만 접근 가능
 	

 	// 작성하고 싶은 자바 코드 작성(변수 선언 등)
 %>
 
 <%! // JSP파일이 최초 실행될 때 한번만 실행할 자바 코드
 	
 	int global = 0;
 
 %>
 <% // JSP파일이 실행될 때마다 한번씩 반복0 실행할 자바 코드
 	int local =  0;
 	// 지역변수이기 때문에 메소드 내에서만 사용 가능 -> 요청할 때마다 0으로 초기화됨
 	// method 밖에서 선언해야 가능
 	// 스크립트릿은 요청이 올때마다 실행되는 코드
 	// 따라서 선언부에서 변수 선언
 	out.println("local : " + ++local);
 	out.println("global : " + ++global);
 	// 매번 out.print 메소드를 쓰기 불편 -> 표현식 사용
 	
 %>
 표현식 : <% out.print(local); %> == <%=local %>
 액션태그 : 
 <%
 	// vo 객체에 정보를 저장한 적 X pageContext.setAttribute("m", vo); 
 	MemberVo v = (MemberVo)pageContext.getAttribute("m"); // m이라는 이름으로 저장된 값을 MemberVo 변수에 담기
 	if(v == null) {
 		v = new MemberVo();
 		pageContext.setAttribute("m", v);
 	}
 	v.setMemId("A001");
 
 	out.print(v.getMemId());
 %>
 <jsp:useBean id="m" class="com.exam.member.MemberVo"></jsp:useBean> 
<%-- 
if(v == null) {
 		v = new MemberVo();
 		pageContext.setAttribute("m", v);
 	} 와 동일
 --%> 
 <%-- m이라는 이름 아래에 memberVo 객체를 생성해서 저장해놓으라고 설정 --%>
 <%-- 자주 사용하는 것들을 넣어 놓음 --%>
 <%-- scope request, session, page, application에다 저장할 수 있음 --%>
 
 <jsp:setProperty name="m" property="memId" value="A001"/>
 <%--
  v.setMemId("A001");
  --%>
 <%-- 객체의 속성에다가 값을 넣으려면 value 태그에 지정 --%>
 
 <jsp:getProperty  name="m" property="memId" />
 <%--
 out.print(v.getMemId()); 와 동일
  --%>
  
 <% 
 	/* request.getRequestDispatcher("/menu.jsp").forward(request, response); */ 
   	request.getRequestDispatcher("/JSP/menu.jsp").include(request, response); 
 %>
 <%--<jsp:forward page="/menu.jsp"></jsp:forward>--%>
  <jsp:include page="/JSP/menu.jsp"></jsp:include> 
</body>
</html>

<%-- HTML처럼 보이는 SERVLET파일 -> 톰캣이 자동으로 JSP파일을 읽어서 서블릿 파일을 만들어서 서비스를 실행 - > out.println을 붙여서 출력
중간에 자바코드를 삽입 -> 자바코드 또한 자동으로 삽입돼서 실행 --%>
<!-- jsp 배포 폴더 찾아가기 -->
<!-- D:\JIWON\web\R_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\exweb\org\apache\jsp\JSP_0020file -->
<!-- 컴파일된 jsp파일에서 jsp서비스 안쪽에 만든 html을 출력  -->
<!-- 서블릿이나 html등 변환된 파일 배포 폴더 -> D:\JIWON\web\R_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps -->