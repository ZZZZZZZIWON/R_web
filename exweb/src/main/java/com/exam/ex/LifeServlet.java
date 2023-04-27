package com.exam.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
// 서블릿의 생명주기(Life Cycle) :
// 서블릿 객체의 생성부터 소멸까지, 특정 시점에 자동으로 실행되는 메서드들
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// <톰캣>
// LifeServlet s = new LifeServlet();
// s.init() -객체가 없을 때 객체 생성 후 init 메서드 호출

// s.service() - 바로 메서드 호출

@WebServlet("/life.do")
public class LifeServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// 서블릿 객체가 처음 생성된 후 최초 1번만 실행
		// 일반적으로 서블릿이 요청을 처리할 때 필요한 자원들을 준비하는 작업을 수행
		System.out.println("LifeServlet init");
	}

//	@Override // 상속한 내용에 이미 존재 -> 덮어씌움(정의할 필요 x)
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// 요청이 올 때마다 1번씩 반복 실행
//		// 서블릿 객체는 1번만 생성 후 스레드를 만들어서 메소드만 실행
//		// static이 안 붙어있으면 instance를 만들어서 실행(톰캣이)
//		System.out.println("LifeServlet service");
//	}
	// HttpServlet의 service() 메서드는 요청방식(get, post 등)에 따라서
	// do요청방식() 메서드를 실행하도록 구현되어 있음
	// if 특정 요청방식으로 요청이 온 경우에만 수행하고 싶은 작업이 있다면
	// -> do요청방식() 메서드를 사용하여 구현 가능(제어문 필요 x)
	// 주석처리를 하지 않으면 내가 만든 서비스 메서드 실행 -> 상속받은 서비스 실행에 방해

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http command 중 하나
		// service와 유사
		// GET 방식으로 요청이 올 때마다 1번씩 반복 실행
		System.out.println("LifeServlet doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 실행시킬 form이 필요(post 방식 지정)
		System.out.println("LifeServlet doPost");
	}
	
	@Override
	public void destroy() {
		// 서블릿 객체가 소멸되기 직전에 마지막으로 1번만 실행
		// 일반적으로 서블릿이 사용하던 자원들을 정리하고 반납하는 작업을 수행
		System.out.println("LifeServlet destroy");
	}

}
