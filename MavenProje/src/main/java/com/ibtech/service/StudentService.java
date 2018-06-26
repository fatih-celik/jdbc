package com.ibtech.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ibtech.model.Student;

public interface StudentService {
	
	public void ekle(Student student) throws SQLException;
	public List<Student> getStudentsList() throws SQLException;
	public Student deleteStudent(Student student) throws SQLException;

}
