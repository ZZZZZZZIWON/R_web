package com.exam.comm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class DriverServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("DriverServlet init() 실행");
		
		String cname = getInitParameter("driver"); // 현재 서블릿의 "driver" 초기화 파라미터 값 읽기
		
		try {
			Class.forName(cname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
