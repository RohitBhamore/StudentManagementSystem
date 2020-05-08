package com.example.StudentManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

}
