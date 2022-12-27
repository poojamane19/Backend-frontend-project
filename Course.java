package com.edu.CollegeManagements.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="courss")
public class Course{
//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course_Title")
	private String courseTitle;
	
	@Column(name="course_Fee")
	private String courseFee;
	
	@Column(name="course_Duration")
	private String courseDuration;
	
	//create constructor
	public Course()
	{
		
	}

	public Course(String courseTitle, String courseFee, String courseDuration) {
		
		this.courseTitle = courseTitle;
		this.courseFee = courseFee;
		this.courseDuration = courseDuration;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(String courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	
   public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	//define tostring

	@Override
	public String toString() {
		return "Course [courseTitle=" + courseTitle + ", courseFee=" + courseFee + ", courseDuration=" + courseDuration
				+ "]";
	}
	
	}

