package com.exam.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDaoBatis implements MemberDao{ // 구현이 되지 않은 인터페이스 MemberDao의 method들 정의하기

	SqlSessionFactory sqlSessionFactory;
	{
		try {
			String resource = "batis/mybatis-config.xml"; // 마이바티스 전체 설정파일 위치_클래스 path 기준(이름이나 경로를 바꿀 때 변경)
			InputStream inputStream= Resources.getResourceAsStream(resource);
			// 설정파일의 내용대로 SqlSessionFactory(마이바티스 본체)를 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // 자동 import 단축키 
	  // ctrl + shift + o
	
	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null; // 초기값으로 null을 줘도 되고 다른 list에 저장해도 됨(new ArrayList<MemberVo>();
		try (SqlSession session = sqlSessionFactory.openSession()) { // getConnection이랑 비슷한 역할
			// 실행할 SQL문과 동일한 이름의 메서드를 사용하여 SQL문 실행
			// SELECT 결과가 1행인 경우 selectOne,  2행 이상인 경우 selectList 메서드 사용  
			// 1. selectOne일 경우, 회원 정보 1개만 전달
			// 2. selectList일 경우, 리스트에 저장된 모든 회원 정보 전달
			// 첫번째 인자로 실행할 SQL문의 고유한 이름을 전달
			// 두번째 인자로 SQL문 실행시 필요한 데이터를 담은 객체를 전달(SELECT시에는 필요 X)
			list = session.selectList("com.exam.member.MemberDao.selectMemberList");
			}
		return list;
	}

	@Override
	public int insertMember(MemberVo vo) {
		return 0;
	}

	@Override
	public int deleteMember(String memId) {
		return 0;
	}

}
