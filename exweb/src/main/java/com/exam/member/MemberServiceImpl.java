package com.exam.member;

import java.util.List;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao = MemberDaoBatis.getInstance();
	
	private MemberServiceImpl() {}
	
	private static MemberService memberService = new MemberServiceImpl();
	public static MemberService getInstance() {
		return memberService;
	}
	
	
	@Override
	public List<MemberVo> selectMemberList() {
		return memberDao.selectMemberList();
	}

	@Override
	public int insertMember(MemberVo vo) {
		return memberDao.insertMember(vo);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}

	@Override
	public MemberVo selectMember(String memId) {
		return memberDao.selectMember(memId);
		
	}

	@Override
	public int updateMember(MemberVo vo) {
		return memberDao.updateMember(vo);
	}

	@Override
	public MemberVo selectLogin(MemberVo vo) {
		return memberDao.selectLogin(vo);
	}

}
