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

import com.edu.CollegeManagements.entity.Course;
import com.edu.CollegeManagements.entity.Teacher;
import com.edu.CollegeManagements.errors.StudentNotFoundException;
//import com.edu.CollegeManagements.service.CourseService;
import com.edu.CollegeManagements.service.TeacherService;

@Controller
@RequestMapping("/api")
public class TeacherController {
	

	
	private TeacherService teacherService;
	@Autowired
	public TeacherController(TeacherService teacherService)
	{
		this.teacherService = teacherService;
		
	}
	
	
	
	
   @RequestMapping(value="/teachers", method=RequestMethod.POST)
	public Teacher addTeacher(@RequestBody Teacher tech)
	{
	   teacherService.addTeacher(tech);
	   return tech;
	}

	@RequestMapping(value="/getalltech")
	public String fetchAllTeacher(Model theModel)
	{
		List<Teacher> teachers=teacherService.findAll();
		theModel.addAttribute("teacherList", teachers);
		return "teacherlist";
	}
	
	@GetMapping("/showforadd")
	public String addTeacher(Model theModel)
	{
		Teacher theTeacher=new Teacher();
		theModel.addAttribute("teacher", theTeacher);
		return "teacheraddfrom";
	}
	
	@RequestMapping(value="/savetech", method=RequestMethod.POST)
	public String saveTeacher(@ModelAttribute("Teacher") Teacher tech)
	{
		teacherService.addTeacher(tech);
		return "redirect:/api/getalltech";
				
	}
	
	@RequestMapping(value="/showforupdate")
	public String updateTeacher(@RequestParam("teacherId")int id,Model theModel)
	{
		System.out.println("Teacher Update form for Id="+id);
		Teacher tech=teacherService.findTeacherById(id);
		theModel.addAttribute("teacher",tech);
		return "teacheraddfrom";
				
	}
	
	@RequestMapping(value="/showfordelete")
	public String deleteTeacher(@RequestParam("teacherId")int id,Model theModel)
	{
		System.out.println("Teacher delete form for Id="+id);
		Teacher tech=teacherService.findTeacherById(id);
		if(tech==null)
		{
			throw new StudentNotFoundException("There is no Teacher with the Id:"+id);
		}
		teacherService.deleteById(id);
		return "redirect:/api/getalltech";
	}
	}


