package com.edu.CollegeManagements.dao;
import java.util.List;

import com.edu.CollegeManagements.entity.Course;

public interface CourseDAO {
	
 List<Course>findAll();
 
 Course findCourseById(int id);
 
 Course addCourse(Course cour);
 
 void deleteById(int id);
 }
