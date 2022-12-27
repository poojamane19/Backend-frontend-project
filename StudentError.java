package com.edu.CollegeManagements.errors;

public class StudentError {
	
    //fields
	int status;
	String message;
	Long timeStamp;
	
	//generate constructor
	public StudentError()
	{
		
	}
	
	//generate constractor using fields
	public StudentError(int status, String message, Long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	}


