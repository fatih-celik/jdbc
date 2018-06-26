package com.ibtech.bean;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import com.ibtech.model.Student;
import com.ibtech.service.StudentService;
import com.ibtech.service.impl.StudentServiceImpl;

@ManagedBean(name="projeBean")
@ViewScoped

public class ProjeBean {
	
	private Student student ;
	private List<Student> studentList; 
	private StudentService studentService;

	/*
	
	public void DbConnection() {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

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
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
		
	
	*/
	

	
	/*
	public void DbConnection() {
        try
        {
            Class.forName("JDBC_DRIVER");
            connect = DriverManager.getConnection("jdbc:h2:~/student");
            stmt = connect.createStatement();
	        String sql =  "CREATE TABLE   Car " + 
	                "(car_id INTEGER not NULL, " + 
	                " cname VARCHAR(255), " +  
	                " color VARCHAR(255), " + 
	                " speed INTEGER, " +  
	                " Manufactured_Country VARCHAR(100), " +  
	                " PRIMARY KEY ( car_id ))";
	        stmt.executeUpdate(sql);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
    
		
	*/

	   
	public ProjeBean() {
		student = new Student();
		studentList = new ArrayList<Student>();
		studentService = new StudentServiceImpl();
	

	}
	
	public void ekle() throws SQLException {
		studentService.ekle(student);
		student = new Student();
	}

	/*
	public void ekle() {
		studentList.add(student);
		student = new Student();
	} */
/*	
	public String deleteAction(Student student) {
	    
		studentList.remove(student);
		return null;
	}
 */
	public void deleteAction(Student student) throws SQLException {
		studentService.deleteStudent(student);
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() throws SQLException {
		return studentService.getStudentsList();
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public String saveAction() throws SQLException {
	    
		//var olan tüm deðerleri al ama editable=false yap
		for (Student student : getStudentList()){
			if(student.isEditable()) {
				studentService.ekle(student);
			}
			student.setEditable(false);
		}
		//sayfaya geri döner
		return null;
		
	}
	
	public String editAction(Student student) {
	    
		student.setEditable(true);
		return null;
	}
	/*
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    */
}
