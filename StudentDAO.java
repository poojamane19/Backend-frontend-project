package com.edu.CollegeManagements.dao;

import java.util.List;

import com.edu.CollegeManagements.entity.Student;

public interface StudentDAO {
	
 List<Student>findAll();
 
 Student findStudentById(int id);
 
 Student addStudent(Student stud);
 
 void deleteById(int id);
 }
