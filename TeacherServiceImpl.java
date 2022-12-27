package com.edu.CollegeManagements.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.CollegeManagements.dao.TeacherDAO;
import com.edu.CollegeManagements.entity.Teacher;


@Service
public class TeacherServiceImpl implements TeacherService{
	
private  TeacherDAO  teacherDAO;
	
	@Autowired
	public TeacherServiceImpl(  TeacherDAO  teacherDAO)
	{
		this. teacherDAO= teacherDAO;
	}

	@Override
	public List<Teacher> findAll()
	{
		return  teacherDAO.findAll();
	}

	@Override
	public Teacher findTeacherById(int id) {
		
		return teacherDAO.findTeacherById(id);
	}
	
	@Override
	public Teacher addTeacher(Teacher tech) {
		return teacherDAO.addTeacher(tech);
		
	}

	@Override
	public void deleteById(int id) {
		teacherDAO.deleteById(id);
		
	}

}
