package com.edu.CollegeManagements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.CollegeManagements.dao. StudentDAO;
import com.edu.CollegeManagements.entity.Student;
@Service
public class StudentServiceImpl implements StudentService{
	
private  StudentDAO  studentDAO;
	
	@Autowired
	public StudentServiceImpl(  StudentDAO  studentDAO)
	{
		this. studentDAO= studentDAO;
	}

	@Override
	public List<Student> findAll()
	{
		return  studentDAO.findAll();
	}

	@Override
	public Student findStudentById(int id) {
		
		return studentDAO.findStudentById(id);
	}
	
	@Override
	public Student addStudent(Student stud) {
		return studentDAO.addStudent(stud);
		
	}

	@Override
	public void deleteById(int id) {
		studentDAO.deleteById(id);
		
	}

}