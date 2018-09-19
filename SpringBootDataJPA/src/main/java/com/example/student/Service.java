package com.example.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private StudentRepository stRepository;

	public Object getAllStudent(){
	
		List<Student> student = new ArrayList<>();
		stRepository.findAll().forEach(student::add);  //--> use :: lamda expression here
		
		return student;
	}
	
	public Student getStudent(String id) {
		return stRepository.findOne(id);
	}

	public void addStudentData(Student st) {
		stRepository.save(st);
		
	}

	public void updateStudentData(Student st, String id) {
		stRepository.save(st);
		
	}

	public void deleteStudentData(String id) {
		stRepository.delete(id);
		
	}


}
