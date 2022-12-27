package com.edu.CollegeManagements.service;

import java.util.List;

import com.edu.CollegeManagements.entity.Student;

public interface StudentService {

	public List<Student>findAll();
	
	public Student findStudentById(int id);
	
	public Student addStudent(Student stud);
	
	public void deleteById(int id);

	}
