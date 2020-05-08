package com.example.StudentManagementSystem.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.StudentManagementSystem.dao.StudentDAO;
import com.example.StudentManagementSystem.entity.Student;

@Repository(value = "StudentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Student> findAll() {
		String sql_query = "from Student";
		List<Student> theStudent = null;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<Student> query = currentSession.createQuery(sql_query, Student.class);
			theStudent = query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return theStudent;
	}

	@Override
	@Transactional
	public Student getStudent(int studentId) {
		Student theStudent = null;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			theStudent = currentSession.get(Student.class, studentId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return theStudent;
	}

	@Override
	@Transactional
	public Student save(Student theStudent) {

		Student tempStudent = null;

		try {
			Session currentSession = entityManager.unwrap(Session.class);
			tempStudent = (Student) currentSession.save(theStudent);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return tempStudent;
	}

	@Override
	@Transactional
	public void update(Student theStudent) {

		try {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.update(theStudent);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	@Transactional
	public void delete(int studentId) {
		
		Student theStudent = null;
		
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			theStudent = currentSession.get(Student.class, studentId);
			currentSession.delete(theStudent);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
