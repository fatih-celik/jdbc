package com.ibtech.service.impl;


import java.sql.SQLException;
import java.util.List;

import com.ibtech.dao.StudentDAO;
import com.ibtech.dao.impl.StudentDAOImpl;
import com.ibtech.model.Student;
import com.ibtech.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	StudentDAO studentDao;
	
	

	public StudentServiceImpl() {
		studentDao = new StudentDAOImpl();
	}



	public void ekle(Student student) throws SQLException {
		studentDao.ekle(student);
		
	}
	


	public List<Student> getStudentsList() throws SQLException {
		
		return studentDao.getStudentsList();
	}



	public Student deleteStudent(Student student) throws SQLException {

		return studentDao.deleteStudent(student);
	}



}
