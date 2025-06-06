package com.example.myApp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService service;
   
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> student = service.getAllStudents();
		for(int i = 0;i<student.size();i++){
			Student s = student.get(i);
			s.setTempId(i+1);
		}
		return student;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		return service.getStudentById(studentId);
	}
	
	@PostMapping("/students")
	public void createStudent(@RequestBody Student student) {
		 service.createStudent(student);
	}
	
	@PutMapping("/students/{studentId}")
    public void updateStudent(@PathVariable int studentId,@RequestBody Student student) {
         service.updateStudent(studentId,student);
    }
	
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable int studentId) {
		 service.deleteStudent(studentId);
	}
	
	
	
	
	
}
