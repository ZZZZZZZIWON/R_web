<%@page import="com.exam.member.MemberVo"%> <%-- �ڹ��� import������ ǥ�� --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" 
    pageEncoding="EUC-KR"%>
    <%-- contentType="text/html; charset=EUC-KR" <- setCharacterEncoding�̶� ���� --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP</title>
</head>
<body>
	<h1>HELLO JSP</h1>

<!-- HTML �ּ� -->
<%-- JSP �ּ� --%>
<%-- 
JSP �������
- ��Ƽ�� : page(���� JSP���� ��ü�� ���� ����), include(�ٸ� JSP���� ����), taglib(�±� ���̺귯�� ���)
	<%@ ��Ƽ��� �Ӽ���="�Ӽ���" %>
- ��ũ��Ʈ���
	- ��Ʈ��Ʈ�� : <% ������ service�޼��� ���ο� �� �ڹ� �ڵ� %>
	- ǥ���� : <%= ���� ��ġ�� ������� ����� �ڹ� �ڵ� %>
	- ����� : <%! ������ service�޼��� �ܺο� �� �ڹ� �ڵ� %>
	- �ּ� 
(�ΰ������� �ʿ��ؼ� ������� ��ҵ�)	
- �׼��±� : ���� ����ϴ� �ڹ� �ڵ带 ��ü�� �� �ִ� �±�(�� ��� X)
- EL(ǥ�����)
- Ŀ�����±�
 --%>
 <%
 	// ���� ������� ��밡���� ���尴ü(�⺻��ü) :
 	// �ڵ��ϼ��ؼ� �� ���� ���� �͵�(ex_ out) - �������� ��ȯ�� �� �ڵ����� ��밡���ϰ� ����)
	// request(��û��ü), response(���䰴ü) - �������� ���ڷ� �ְ� �޴� ��ü��
	// session(���ǰ�ü), application(�������ؽ�Ʈ��ü) - ���������� �г����� �ٸ��� ����Ǵ� ��ü��
	// out(������½�Ʈ��), config(��������), pageContext(���� JSP���Ͽ� ���� ��� ������ ���� ��ü- ���尴ü ��ü�� ���� ��ü)
	// page(���� JSP������ü ��ü), exception(�߻��� ���� - ���� ó���� JSP�� ����� �� ������ ���� ������ ���� ��ü)	
 	out.println("<p>");
	out.println("����� ����");
 	out.println(session == request.getSession()); // true
 	out.println(application == getServletContext()); // true
 	out.println(config == getServletConfig()); // true
 	// �̹� ������ ��Ƴ��� ������ �̸��� ȣ���ؼ� ��� ����
 	
 	// JSP���� ������ ������ �� �ִ� �� �ϳ� �߰� -> pagecontext 
 	// pageContext ��ü�� ���� JSP ���Ͽ����� ��밡���� �����͸� �Ӽ����� ���� ����
 	pageContext.setAttribute("pa", "pv"); 
 	out.println(pageContext.getAttribute("pa")); 
 	// ���� �����ϴ� ��ó�� ���� ����
 	// pageContext ��ü���� �ٸ� ���� ��ü���� ��� ����Ǿ� ����(request, response, session, application, out, config, exception)
 	out.println(request==pageContext.getRequest());
 	out.println(response==pageContext.getResponse());
 	out.println(session==pageContext.getSession());
 	out.println(application==pageContext.getServletContext());
 	out.println("</p>");
 	// EL������ ���尴ü �̸��� ���� ������ �ȵ� -> pageContext�θ� ���� ����
 	

 	// �ۼ��ϰ� ���� �ڹ� �ڵ� �ۼ�(���� ���� ��)
 %>
 
 <%! // JSP������ ���� ����� �� �ѹ��� ������ �ڹ� �ڵ�
 	
 	int global = 0;
 
 %>
 <% // JSP������ ����� ������ �ѹ��� �ݺ�0 ������ �ڹ� �ڵ�
 	int local =  0;
 	// ���������̱� ������ �޼ҵ� �������� ��� ���� -> ��û�� ������ 0���� �ʱ�ȭ��
 	// method �ۿ��� �����ؾ� ����
 	// ��ũ��Ʈ���� ��û�� �ö����� ����Ǵ� �ڵ�
 	// ���� ����ο��� ���� ����
 	out.println("local : " + ++local);
 	out.println("global : " + ++global);
 	// �Ź� out.print �޼ҵ带 ���� ���� -> ǥ���� ���
 	
 %>
 ǥ���� : <% out.print(local); %> == <%=local %>
 �׼��±� : 
 <%
 	// vo ��ü�� ������ ������ �� X pageContext.setAttribute("m", vo); 
 	MemberVo v = (MemberVo)pageContext.getAttribute("m"); // m�̶�� �̸����� ����� ���� MemberVo ������ ���
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
 	} �� ����
 --%> 
 <%-- m�̶�� �̸� �Ʒ��� memberVo ��ü�� �����ؼ� �����س������ ���� --%>
 <%-- ���� ����ϴ� �͵��� �־� ���� --%>
 <%-- scope request, session, page, application���� ������ �� ���� --%>
 
 <jsp:setProperty name="m" property="memId" value="A001"/>
 <%--
  v.setMemId("A001");
  --%>
 <%-- ��ü�� �Ӽ����ٰ� ���� �������� value �±׿� ���� --%>
 
 <jsp:getProperty  name="m" property="memId" />
 <%--
 out.print(v.getMemId()); �� ����
  --%>
  
 <% 
 	/* request.getRequestDispatcher("/menu.jsp").forward(request, response); */ 
   	request.getRequestDispatcher("/JSP/menu.jsp").include(request, response); 
 %>
 <%--<jsp:forward page="/menu.jsp"></jsp:forward>--%>
  <jsp:include page="/JSP/menu.jsp"></jsp:include> 
</body>
</html>

<%-- HTMLó�� ���̴� SERVLET���� -> ��Ĺ�� �ڵ����� JSP������ �о ���� ������ ���� ���񽺸� ���� - > out.println�� �ٿ��� ���
�߰��� �ڹ��ڵ带 ���� -> �ڹ��ڵ� ���� �ڵ����� ���Եż� ���� --%>
<!-- jsp ���� ���� ã�ư��� -->
<!-- D:\JIWON\web\R_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\exweb\org\apache\jsp\JSP_0020file -->
<!-- �����ϵ� jsp���Ͽ��� jsp���� ���ʿ� ���� html�� ���  -->
<!-- �����̳� html�� ��ȯ�� ���� ���� ���� -> D:\JIWON\web\R_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps -->