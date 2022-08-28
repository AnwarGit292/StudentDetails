package com.student.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.StudentDetails;
import com.student.repositary.StudentRepo;
import com.student.service.StudentService;

@Service
public class StudentSerImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	
	@Override
	public StudentDetails createStudent(StudentDetails studentDetails) {
	
		this.studentRepo.save(studentDetails);
		return studentDetails;
	}

	@Override
	public StudentDetails updateStudent(StudentDetails student, Integer studentId) {
		StudentDetails findById = this.studentRepo.findById(studentId).orElseThrow();
		
		findById.setName(student.getName());
		findById.setEmail(student.getEmail());
		findById.setPassword(student.getPassword());
		findById.setAbout(student.getAbout());
		
		StudentDetails save = this.studentRepo.save(findById);
		
		return save;
	}

	@Override
	public StudentDetails getStudentById(Integer studentId) {
		 StudentDetails findById = this.studentRepo.findById(studentId).orElseThrow();
		return findById;
	}

	@Override
	public List<StudentDetails> getAllStudents() {
		List<StudentDetails> findAll = this.studentRepo.findAll();
		
		return findAll;
	}

	@Override
	public void deleteStudent(Integer userId) {
	     this.studentRepo.deleteById(userId);

	}

}
