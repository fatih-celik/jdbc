package com.ibtech.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibtech.dao.StudentDAO;
import com.ibtech.model.Student;

public class StudentDAOImpl implements StudentDAO {
	
	
	public Connection DbConnection() {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/ex", "postgres",
					"1234");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		return connection;
	}
	

	public ResultSet ekle(Student student) throws SQLException {
		
		ResultSet rs = null;
		if(student.isEditable() == true) {
			
			String sql = "Update public.\"Students\" Set name=? AND surname=? "
					+ "AND title=? Where sicil= ?";
			
			PreparedStatement prepStmt = DbConnection().prepareStatement(sql);
			prepStmt.setString(1, student.getAd());
			prepStmt.setString(2, student.getSoyad());
			prepStmt.setString(3, student.getTitle());
			prepStmt.setInt(4, student.getSicilNo());
			rs = prepStmt.executeQuery();
			prepStmt.close();
			DbConnection().close();
			
		} else {
			String sql = "INSERT INTO public.\"Students\"(sicil, name, surname, title) " +
	                "VALUES (?,?,?,?)";
			
			PreparedStatement prepStmt = DbConnection().prepareStatement(sql);
			prepStmt.setInt(1, student.getSicilNo());
			prepStmt.setString(2, student.getAd());
			prepStmt.setString(3, student.getSoyad());
			prepStmt.setString(4, student.getTitle());
			rs = prepStmt.executeQuery();
			prepStmt.close();
			DbConnection().close();
		}
		return rs;
	}

	public List<Student> getStudentsList() throws SQLException {
		
		List<Student> studentsList = new ArrayList<Student>();
		
		String sql = "Select * from public.\"Students\"";
		PreparedStatement prepStmt = DbConnection().prepareStatement(sql);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			  Student student = new Student();
			  
			  student.setSicilNo(rs.getInt("sicil"));
			  student.setAd(rs.getString("name"));
			  student.setSoyad(rs.getString("surname"));
			  student.setTitle(rs.getString("title"));

			  studentsList.add(student);
			}
		
		return studentsList;
	}


	public Student deleteStudent(Student student) throws SQLException {
		
		String sql = "Delete from public.\"Students\" Where sicil = ?";
		PreparedStatement prepStmt = DbConnection().prepareStatement(sql);
		prepStmt.setInt(1, student.getSicilNo());
		prepStmt.executeQuery();
		return null;
	}

}
