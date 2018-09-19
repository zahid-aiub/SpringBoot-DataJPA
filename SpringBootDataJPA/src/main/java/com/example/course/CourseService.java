package com.example.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	public Object getAllCourse(String studentId){
		List<Course> courses = new ArrayList<>();
		courseRepo.findByStudentId(studentId)
		.forEach(courses::add);
		//courseRepo.findByStudentId(studentId).forEach(courses::add);  //--> use :: lamda expression here
		
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepo.findOne(id);
	}

	public void addCourse(Course course) {
		courseRepo.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRepo.save(course);
		
	}

	public void deleteCourse(String id) {
		courseRepo.delete(id);
		
	}


}
