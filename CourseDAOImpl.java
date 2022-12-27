package com.edu.CollegeManagements.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.CollegeManagements.entity.Course;
import com.edu.CollegeManagements.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class CourseDAOImpl  implements CourseDAO {
	
	private EntityManager entityManager;
	//set up constructor injection
	@Autowired
	public CourseDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Course> findAll() {
		
		//get the current session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create the query ,execute and get the result list
		List<Course>cour=currentSession.createQuery("from Course",Course.class).getResultList();
		
		//result the result
		 System.out.println(cour.toString());
		return cour;
	}
	//find an Course by 
	@Transactional
	public Course findCourseById(int id)
	{
		Session session=entityManager.unwrap(Session.class);
		Course cour=session.get(Course.class,id);
		return cour;
	}

	//Add a new Course
	@Transactional
	public Course addCourse(Course cour) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(cour);
		return cour;
	}
	
	
	
	//delete an Course by id
	@Transactional
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		//session.remove(id);
		Query query=session.createQuery("delete from Course where id=:courseId");
		query.setParameter("courseId", id);
		query.executeUpdate();
		
	}


	
	
}
