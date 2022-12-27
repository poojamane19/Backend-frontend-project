package com.edu.CollegeManagements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.edu.CollegeManagements"})
public class CollegeManagementsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementsApplication.class, args);
		System.out.println("Hi");
	}

}
 