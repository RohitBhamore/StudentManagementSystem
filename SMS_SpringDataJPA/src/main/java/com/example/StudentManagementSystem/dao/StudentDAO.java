package com.example.StudentManagementSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{
	
	Student findByFirstName(String firstName);
	
	List<Student> findByIdGreaterThan(int id);
	
	@Query("from Student order by firstName")
	List<Student> findByFirstNameSorted();
	
	@Query("delete from Student where firstName=?1")
	void DeleteByFirstName(String name);

 
}
