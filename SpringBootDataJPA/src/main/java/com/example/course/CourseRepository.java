package com.example.course;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.student.Student;

public interface CourseRepository extends CrudRepository<Course, String> {  //-->> Now it is my Custom Repository of Student class

	public List<Course> findByStudentId(String studentId);
}
