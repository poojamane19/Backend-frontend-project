package com.edu.CollegeManagements.errors;

public class StudentNotFoundException extends  RuntimeException{

	
	public StudentNotFoundException(String message) 
		{
			super(message);	
		}
	}

