package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.StudentDetails;
import com.student.repositary.StudentRepo;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/")
	public ResponseEntity<StudentDetails> createStudent(@RequestBody StudentDetails studentDetails){
		StudentDetails createStudent = this.studentService.createStudent(studentDetails);
		
		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDetails>> getAllStudent(){
		List<StudentDetails> allStudents = this.studentService.getAllStudents();
		
		
		return ResponseEntity.ok(allStudents);
	}

	
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDetails> updateStudent(@RequestBody StudentDetails studentDetails, @PathVariable("studentId") Integer Id){
		
		StudentDetails updateduser = this.studentService.updateStudent(studentDetails, Id);
		
		return ResponseEntity.ok(updateduser);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDetails> findById(@PathVariable("studentId" ) Integer Id){
		StudentDetails studentById = this.studentService.getStudentById(Id);
		
		return ResponseEntity.ok(studentById);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<StudentDetails> deleteById(@PathVariable("studentId") Integer Id){
		this.studentService.deleteStudent(Id);
		return new ResponseEntity<StudentDetails>(HttpStatus.OK);
	}
	
}
