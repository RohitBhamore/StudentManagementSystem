package com.example.StudentManagementSystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.dao.StudentDAO;
import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.service.StudentService;

@Service(value = "StudentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO studentDAO;

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public Student getStudent(int studentId) {

		Student theStudent = null;
		Optional<Student> result = studentDAO.findById(studentId);

		if (result.isPresent()) {
			theStudent = result.get();
		}

		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentDAO.save(theStudent);
	}

	@Override
	public void delete(int studentId) {
		studentDAO.deleteById(studentId);
	}

	@Override
	public Student findByFirstName(String firstName) {
		return studentDAO.findByFirstName(firstName);
	}

	@Override
	public List<Student> findByFirstNameSorted() {
		return studentDAO.findByFirstNameSorted();
	}

	
}
