package com.edu.CollegeManagements.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.CollegeManagements.dao.CourseDAO;
import com.edu.CollegeManagements.entity.Course;


@Service
public class CourseServiceImpl implements CourseService{
	
private  CourseDAO  courseDAO;
	
	@Autowired
	public CourseServiceImpl(  CourseDAO  courseDAO)
	{
		this. courseDAO  = courseDAO;
	}

	@Override
	public List<Course> findAll()
	{
		return  courseDAO.findAll();
	}

	@Override
	public Course findCourseById(int id) {
		
		return courseDAO.findCourseById(id);
	}
	
	@Override
	public Course addCourse(Course cour) {
		return courseDAO.addCourse(cour);
		
	}

	@Override
	public void deleteById(int id) {
		courseDAO.deleteById(id);
		
	}

	

}
