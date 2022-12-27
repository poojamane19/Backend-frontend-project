package com.edu.CollegeManagements.dao;

import java.util.List;

import com.edu.CollegeManagements.entity.Teacher;

public interface TeacherDAO {
	
 List<Teacher>findAll();
 
 Teacher findTeacherById(int id);
 
 Teacher addTeacher(Teacher tech);
 
 void deleteById(int id);
 }
