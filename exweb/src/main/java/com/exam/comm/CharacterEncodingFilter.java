package com.exam.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// 필터 : 서블릿의 실행 전후에 들어가서 실행
//	   - 다수의 서블릿들이 수행하는 공통 작업을 실행할 때 사용
//     - Filter 인터페이스를 구현하여 필터 클래스 정의
// 			1. web.xml에 <filter> 태그로 등록
//			2. 클래스에 @WebFilter 적용

public class CharacterEncodingFilter implements Filter{
	
	private String enc;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터가 처음 생성됐을 때 1번 실행
		System.out.println("CharEncFilter init() 실행");

		enc = filterConfig.getInitParameter("encoding"); // 필드로 변경(메소드 밖에서 선언 - 클래스 내에서 사용 가능)
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 필터의 경로에 맞는 요청이 올 때마다 한번씩 실행
		System.out.println("CharacterEncodingFilter doFilter() 실행");
		
		// 서블릿 실행 전에 할 것을 정의
		// 인코딩 설정
		request.setCharacterEncoding(enc); // if) 나중에 바꿀 일이 있을 때(필터를 공유해서 다른 방식의 인코딩을 사용해야 할 때)
//												      따로 설정 파일로 지정
		
		// 이후 실행될 필터 또는 서블릿들을 실행
		chain.doFilter(request, response); // 서블릿 실행
		
		// 서블릿이 응답을 만들어낸 후에 할 일
	}
	
	@Override
	public void destroy() {
		// 필터 객체가 소멸(삭제)되기 전에 1번 실행
		System.out.println("CharEncFilter destroy() 실행");
	}
	
}
