package com.jsp.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudentProject {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Root");
		Statement st = con.createStatement();
		st.execute("create table prostudent(id int,name varchar(20),yop int,age int,mobileno varchar(10)");
		System.out.println("created");

	}

}
