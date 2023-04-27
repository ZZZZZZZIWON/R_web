package com.exam.member;

import java.util.List;

public interface MemberDao {

	// MemListServlet에서 사용
	List<MemberVo> selectMemberList();

	// MemAddServlet에서 사용
	int insertMember(MemberVo vo);

	// MemDelServlet에서 사용
	int deleteMember(String memId);

}