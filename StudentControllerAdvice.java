package com.edu.CollegeManagements.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<StudentError>handleException( StudentNotFoundException ex)
	{
		StudentError err=new StudentError();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(ex.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentError>(err,HttpStatus.NOT_FOUND);
	}
}
