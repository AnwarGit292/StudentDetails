package com.student.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.StudentDetails;

public interface StudentRepo extends JpaRepository<StudentDetails, Integer>{

}
