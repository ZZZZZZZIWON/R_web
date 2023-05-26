package com.exam.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.member.MemberVo;

public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println("URI : " + req.getRequestURI());
		System.out.println("URL : " + req.getRequestURL());

		if (!req.getRequestURI().equals(req.getContextPath() + "/member/login.do")) {

			HttpSession session = req.getSession();
			MemberVo vo = (MemberVo) session.getAttribute("loginUser");
			if (vo == null) {
				resp.sendRedirect(req.getContextPath() + "/member/login.do");
				return;
			}

		}
		chain.doFilter(request, response);

	}

}
