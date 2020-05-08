package com.example.StudentManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.StudentService;

@RestController
@RequestMapping("/test/api/")
public class MyController {

	@Autowired
	StudentService service;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {

		List<Student> theStudent = null;

		try {
			theStudent = service.findAll();
			return new ResponseEntity<List<Student>>(theStudent, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<List<Student>>(theStudent, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable int studentId) {

		Student theStudent = null;

		try {
			theStudent = service.getStudent(studentId);
			return new ResponseEntity<Student>(theStudent, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Student>(theStudent, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student theStudent) {

		Student currentStudent = null;

		try {
			currentStudent = service.save(theStudent);
			return new ResponseEntity<Student>(currentStudent, HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Student>(currentStudent, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/students")
	public ResponseEntity<Student> updateStudent(@RequestBody Student theStudent) {
		try {
			service.update(theStudent);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

	}
	
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int studentId) {
		try {
			service.delete(studentId);
			return new ResponseEntity<Student>(HttpStatus.OK);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}

	}

}
