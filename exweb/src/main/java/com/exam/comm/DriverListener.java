package com.exam.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// 리스너 : 특정 사건이 발생했을 떄 자동으로 실행되는 객체
//		 - 감지하고 싶은 사건의 종류에 따라서 그에 맞는 리스너 인터페이스를 구현
//		  1. web.xml 파일에 <listner>를 사용하여 등록하거나 
// 		  2. @WebListner를 클래스에 적용

//@WebListner
public class DriverListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		서블릿 컨텍스트 객체가 처음 생성(서버(톰캣) 시작지점)된 시점에 실행되는 메서드
		System.out.println("DriverListener contextInitialized() 실행");
		
		ServletContext context = sce.getServletContext(); // 생성된 서블릿 컨텍스트 객체 가져오기(이벤트 객체 sce 안에 저장)
		// "driver"라는 이름으로 저장되어 있는 컨텍스트 파라미텉 값 읽기
		String cname = context.getInitParameter("driver");
		
		// 애플리케이션에 JDBC 실행
		try {
			Class.forName(cname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
//		서블릿 컨텍스트 객체가 소멸(서버(톰캣) 종료지점)되기 직전에 실행되는 메서드
		System.out.println("DriverListener contextDestroyed() 실행");
	
	}
 
	
}
