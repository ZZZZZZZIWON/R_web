package com.exam.student;

public class StudentVo { 
	// VO = value object _DB에 있는 레코드 하나를 담을 수 있는 클래스)
	// 문자열 3개와 정수 1개를 담을 수 있도록 정의
	private String stuNo; //mem_id가 아니라서 불러올 수 없음(So, 테이블 column이름에 별칭을 memId로 설정)
	private String stuName;
	private int stuScore;
	
	
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuScore() {
		return stuScore;
	}
	public void setStuScore(int stuScore) {
		this.stuScore = stuScore;
	}	
	
	
}
