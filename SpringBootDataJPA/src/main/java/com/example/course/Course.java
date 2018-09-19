package com.example.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.example.student.Student;

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	private String discreption;
	@ManyToOne
	private Student student;
	
	public Course() {
		
	}
	
	public Course(String id, String name, String dept, String studentId) {
		super();
		this.id = id;
		this.name = name;
		this.discreption = dept;
		this.student = new Student(studentId, "","");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscreption() {
		return discreption;
	}

	public void setDiscreption(String dept) {
		this.discreption = dept;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
