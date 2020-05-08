package com.example.StudentManagementSystem.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.dao.StudentDAO;
import com.example.StudentManagementSystem.entity.Student;

@Repository(value = "StudentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Student> findAll() {
		String sql_query = "from Student";
		List<Student> theStudent = null;
		try {
			TypedQuery<Student> theQuery = entityManager.createQuery(sql_query, Student.class);
			theStudent = theQuery.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return theStudent;
	}

	@Override
	public Student getStudent(int studentId) {
		Student theStudent = null;
		try {
			theStudent = entityManager.find(Student.class, studentId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return theStudent;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Student theStudent) {
		Student tempStudent = null;
		try {
			tempStudent =  entityManager.merge(theStudent);
			theStudent.setId(tempStudent.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(int studentId) {
		Student theStudent = null;
		try {
			theStudent = entityManager.find(Student.class, studentId);
			entityManager.remove(theStudent);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
