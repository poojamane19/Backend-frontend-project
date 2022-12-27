package com.edu.CollegeManagements.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.CollegeManagements.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl  implements StudentDAO {
	
	private EntityManager entityManager;
	//set up constructor injection
	@Autowired
	public StudentDAOImpl (EntityManager entityManager) 
	{
	 this.entityManager=entityManager;	
	}

	@Transactional
	public List<Student> findAll() {
		
		//get the current session
		Session currentSession=entityManager.unwrap(Session.class);
		
		//create the query ,execute and get the result list
		List<Student>stud=currentSession.createQuery("from Student",Student.class).getResultList();
		
		//result the result
		 System.out.println(stud.toString());
		return stud;
	}
	//find an employee by id
	@Transactional
	public Student findStudentById(int id)
	{
		Session session=entityManager.unwrap(Session.class);
		Student stud=session.get(Student.class,id);
		return stud;
	}

	//Add a new employee
	@Transactional
	public Student addStudent(Student stud) {
		Session session=entityManager.unwrap(Session.class);	
		session.saveOrUpdate(stud);
		return stud;
	}
	
	
	
	//delete an employee by id
	@Transactional
	public void deleteById(int id) {
		Session session=entityManager.unwrap(Session.class);
		//session.remove(id);
		Query query=session.createQuery("delete from Student where id=:studentId");
		query.setParameter("studentId", id);
		query.executeUpdate();
		
	}

	
	
}
