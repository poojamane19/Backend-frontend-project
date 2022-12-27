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
import com.edu.CollegeManagements.errors.StudentNotFoundException;
import com.edu.CollegeManagements.service.CourseService;


@Controller
@RequestMapping("/api")
public class CourseController {
	
	private  CourseService  courseService;
	
	@Autowired
	public  CourseController( CourseService  courseService)
	{
		this. courseService =  courseService;
	}

	@RequestMapping(value="/welcome")
	public String sayHello(Model theModel)
	{      
	theModel.addAttribute("theDate", new java.util.Date());
	return "index";
	}
	
   @RequestMapping(value="/courses", method=RequestMethod.POST)
	public  Course addCourse(@RequestBody Course cour)
	{
	   courseService.addCourse(cour);
	return cour;
	}

	@RequestMapping(value="/getallcour")
	public String fetchAllCourse(Model theModel)
	{
		List<Course> courses=courseService.findAll();
		theModel.addAttribute("courseList", courses);
		return "courselist";
	}
	
	@GetMapping("/showformadd")
	public String addCourse(Model theModel)
	{
		Course theCourse=new Course();
		theModel.addAttribute("course", theCourse);
		return "courseaddfrom";
	}
	
	@RequestMapping(value="/savecour", method=RequestMethod.POST)
	public String saveCourse(@ModelAttribute("course") Course cour)
	{
		courseService.addCourse(cour);
		return "redirect:/api/getallcour";
				
	}
	
	@RequestMapping(value="/showupdate")
	public String updateCourse(@RequestParam("courseId")int id,Model theModel)
	{
		System.out.println("Course Update form for Id="+id);
		Course cour=courseService.findCourseById(id);
		theModel.addAttribute("course",cour);
		return "courseaddfrom";
				
	}
	
	@RequestMapping(value="/showdelete")
	public String deleteCourse(@RequestParam("courseId")int id,Model theModel)
	{
		System.out.println("Course delete form for Id="+id);
		Course cour=courseService.findCourseById(id);
		if(cour==null)
		{
			throw new StudentNotFoundException("There is no Course with the Id:"+id);
		}
		courseService.deleteById(id);
		return "redirect:/api/getallcour";
	}
	}


