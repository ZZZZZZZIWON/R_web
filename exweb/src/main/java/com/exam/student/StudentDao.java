package com.exam.student;

import java.util.List;

public interface StudentDao {

	// MemListServlet에서 사용
	List<StudentVo> selectStudentList();

	// MemAddServlet에서 사용
	int insertStudent(StudentVo vo);

	// MemDelServlet에서 사용
	int deleteStudent(String stuNo);
	

}