package com.example.StudentManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.entity.Student;

@Service
public interface StudentService {

	public List<Student> findAll();

	public Student getStudent(int studentId);

	public Student save(Student theStudent);

	public void update(Student theStudent);

	public void delete(int studentId);
}
