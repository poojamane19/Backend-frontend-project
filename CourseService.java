package com.edu.CollegeManagements.service;
import java.util.List;

import com.edu.CollegeManagements.entity.Course;

public interface CourseService {

	public List<Course>findAll();
	
	public Course findCourseById(int id);
	
	public Course addCourse(Course cour);
	
	public void deleteById(int id);


}

