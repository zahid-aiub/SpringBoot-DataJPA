package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.Course;
import com.example.course.CourseService;

@RestController
public class Controller {
	
	@RequestMapping("/show")
	public String show() {
		return "----*************** HELLO *************------";
	}
	
	//----------------------------------------------------------------------------------
	
	@Autowired
	private Service sv;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/getStudents")
	public Object gelAll() {
		
		return sv.getAllStudent();
	}
	
	@RequestMapping("/getStudents/{id}")
	public Student getSpecificStudent(@PathVariable String id) {
		
		return sv.getStudent(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/addStudent")
	public void addStudent(@RequestBody Student st) {
		sv.addStudentData(st);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateStudent/{id}")
	public void updateStudent(@RequestBody Student st, @PathVariable String id) {
		sv.updateStudentData(st,id);
	}
	
	@RequestMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable String id) {
		sv.deleteStudentData(id);
	}
	
	//*****************************************************************************************************
	
	@RequestMapping("/course")
	public String Show() {
		return "********** In Course Package ************* ";
	}
	
	@RequestMapping("/getStudents/{id}/courses")
	public Object gelAllCourse(@PathVariable String id) {
		
		return courseService.getAllCourse(id);
	}
	
	@RequestMapping("/getStudents/{studentId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		
		return courseService.getCourse(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/student/{studentId}/course")
	public void addSpecificCourse(@RequestBody Course course, @PathVariable String studentId) {
		course.setStudent(new Student(studentId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/student/{studentId}/course/{id}")
	public void updateSpecific(@RequestBody Course course, @PathVariable String studentId, @PathVariable String id) {
		course.setStudent(new Student(studentId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/student/{studentId}/course/{id}")
	public void deleteSpecificCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}

}
