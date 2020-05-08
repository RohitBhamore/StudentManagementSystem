package com.example.StudentManagementSystem.service.impl;

import java.util.List;

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
		return studentDAO.getStudent(studentId);
	}

	@Override
	public Student save(Student theStudent) {
		return studentDAO.save(theStudent);
	}

	@Override
	public void update(Student theStudent) {
		studentDAO.update(theStudent);
	}

	@Override
	public void delete(int studentId) {
		studentDAO.delete(studentId);
	}
	
	
	

}
