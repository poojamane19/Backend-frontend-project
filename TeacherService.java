package com.edu.CollegeManagements.service;

import java.util.List;

import com.edu.CollegeManagements.entity.Teacher;

public interface TeacherService {

	public List<Teacher>findAll();
	
	public Teacher findTeacherById(int id);
	
	public Teacher addTeacher(Teacher tech);
	
	public void deleteById(int id);

	}