package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.function.Consumer;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student_details")
@Setter
@Getter

@NoArgsConstructor
public class StudentDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Id;
	
	@Column(name = "student_name", nullable = false, length = 50)
	String name;
	String email;
	String password;
	String about;
	
	

}
