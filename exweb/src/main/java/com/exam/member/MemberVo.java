package com.exam.member;

public class MemberVo { 
	// VO = value object _DB에 있는 레코드 하나를 담을 수 있는 클래스)
	// 문자열 3개와 정수 1개를 담을 수 있도록 정의
	private String memId; //mem_id가 아니라서 불러올 수 없음(So, 테이블 column이름에 별칭을 memId로 설정)
	private String memPass;
	private String memName;
	private int memPoint;
	// 자바) 캡슐화 _ private 접근제어자를 를 이용 직접 접근을 막음
	// private을 붙이지 않으면)
	// MemberVo vo = new MemberVo();
	// vo.memId; 등 -> 자바에서는 허용X
	// So, 밖에서 필드를 사용할 수 있도록 getter&setter method를 설정해야 함
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	
	
}
