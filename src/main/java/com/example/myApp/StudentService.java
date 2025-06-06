package com.example.myApp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {
	
	@Autowired
	StudentDao repo;

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return repo.findById(studentId).orElse(new Student());
	}

	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}
	
	 public Student updateStudent(int studentId,Student student) {
		 Optional<Student> existingStudent = repo.findById(studentId);

		    if (existingStudent.isPresent()) {
		        // If exists, update the existing record
		       return repo.save(student);
		    } else {
		        // Handle the case where the student doesn't exist (you can return an error response if needed)
		        throw new RuntimeException("Student not found with ID " + studentId);
		    }
	    }

	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		 repo.deleteById(studentId);
	}
	
	

}
