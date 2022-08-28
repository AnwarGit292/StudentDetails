package com.student.service;

import java.util.List;


import com.student.entity.StudentDetails;


public interface StudentService {
	
	StudentDetails createStudent(StudentDetails studentDetails);
	
	StudentDetails updateStudent(StudentDetails student, Integer studentId);
	
	StudentDetails getStudentById(Integer studentId);
	
	List<StudentDetails> getAllStudents();
	
	void deleteStudent(Integer userId);
	

}
