package com.edu.CollegeManagements.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.CollegeManagements.entity.Student;
import com.edu.CollegeManagements.errors.StudentNotFoundException;
import com.edu.CollegeManagements.service.StudentService;

@Controller
@RequestMapping("/api")
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}

	/*@RequestMapping(value="/welcome")
	public String sayHello(Model theModel)
	{      
	theModel.addAttribute("theDate", new java.util.Date());
	return "helloworld";
	}*/
	
   @RequestMapping(value="/students", method=RequestMethod.POST)
	public Student addStudent(@RequestBody Student stud)
	{
	   studentService.addStudent(stud);
	return stud;
	}

	@RequestMapping(value="/getallstud")
	public String fetchAllStudent(Model theModel)
	{
		List<Student> students=studentService.findAll();
		theModel.addAttribute("studentList", students);
		return "studentlist";
	}
	
	@GetMapping("/showformforadd")
	public String addStudent(Model theModel)
	{
		Student theStudent=new Student();
		theModel.addAttribute("student", theStudent);
		return "studentaddfrom";
	}
	
	@RequestMapping(value="/savestud", method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student stud)
	{
		studentService.addStudent(stud);
		return "redirect:/api/getallstud";
				
	}
	
	@RequestMapping(value="/showformforupdate")
	public String updateStudent(@RequestParam("studentId")int id,Model theModel)
	{
		System.out.println("Student Update form for Id="+id);
		Student stud=studentService.findStudentById(id);
		theModel.addAttribute("student",stud);
		return "studentaddfrom";
				
	}
	
	@RequestMapping(value="/showformfordelete")
	public String deleteStudent(@RequestParam("studentId")int id,Model theModel)
	{
		System.out.println("Student delete form for Id="+id);
		Student stud=studentService.findStudentById(id);
		if(stud==null)
		{
			throw new StudentNotFoundException("There is no Student with the Id:"+id);
		}
		studentService.deleteById(id);
		return "redirect:/api/getallstud";
	}
	}

