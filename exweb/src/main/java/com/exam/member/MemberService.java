package com.exam.member;

import java.util.List;

public interface MemberService {

	// MemListServlet에서 사용
	List<MemberVo> selectMemberList();

	// MemAddServlet에서 사용
	int insertMember(MemberVo vo);

	// MemDelServlet에서 사용
	int deleteMember(String memId);

	// MemEditServlet에서 사용
	MemberVo selectMember(String string);

	// MemEditServlet에서 사용
	int updateMember(MemberVo vo);

	// LoginServlet에서 사용
	MemberVo selectLogin(MemberVo vo);
}