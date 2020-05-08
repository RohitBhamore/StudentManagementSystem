package com.example.StudentManagementSystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.entity.Student;

@Repository
public interface StudentDAO {

	public List<Student> findAll();

	public Student getStudent(int studentId);

	public Student save(Student theStudent);

	public void update(Student theStudent);

	public void delete(int studentId);
}
