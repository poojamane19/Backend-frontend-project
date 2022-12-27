package com.edu.CollegeManagements.entity;

//import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="teachers")
public class Teacher{
//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;

	//@OneToOne(mappedBy="teacher")
	//List<Course> course;
	
	//create constructor
	public Teacher()
	{
		
	}

	public Teacher(String firstName, String lastName, String email,String address) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address=address;
	}
	//generate getter and setter

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//define tostring
	
    @Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	}
