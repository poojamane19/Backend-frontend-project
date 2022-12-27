package com.edu.CollegeManagements.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.edu.CollegeManagements.entity.Teacher;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class TeacherDAOImpl  implements TeacherDAO {
	
	private EntityManager entityManager;
	//set up constructor injection
	@Autowired
	public TeacherDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Teacher> findAll() {
		
		//get the current session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create the query ,execute and get the result list
		List<Teacher>tech=currentSession.createQuery("from Teacher",Teacher.class).getResultList();
		
		//result the result
		 System.out.println(tech.toString());
		return tech;
	}
	//find an Teacher by id
	@Transactional
	public Teacher findTeacherById(int id)
	{
		Session session=entityManager.unwrap(Session.class);
		Teacher tech=session.get(Teacher.class,id);
		return tech;
	}

	//Add a new Teacher
	@Transactional
	public Teacher addTeacher(Teacher tech) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(tech);
		return tech;
	}
	
	
	
	//delete an Teacher by id
	@Transactional
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		//session.remove(id);
		Query query=session.createQuery("delete from Teacher where id=:teacherId");
		query.setParameter("teacherId", id);
		query.executeUpdate();
		
	}

	}
