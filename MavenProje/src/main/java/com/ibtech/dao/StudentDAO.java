package com.ibtech.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ibtech.model.Student;

public interface StudentDAO {
	
	public ResultSet ekle(Student student) throws SQLException;
	public List<Student> getStudentsList() throws SQLException;
	public Connection DbConnection();
	public Student deleteStudent(Student student) throws SQLException;
}
