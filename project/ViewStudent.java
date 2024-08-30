package com.jsp.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/viewpro")
public class ViewStudent extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Root");
	//Statement st = con.createStatement();
	PreparedStatement ps = con.prepareStatement("select * from prostudent where id = ?");
	ps.setInt(1,Integer.parseInt(id));
	PrintWriter pout = resp.getWriter();
	//ResultSet rs = st.executeQuery("select * from prostudent where id = ?");
	ResultSet rs =ps.executeQuery();
	while(rs.next()) {
		pout.println("<h1>"+rs.getInt(1)+"</h1>");
		pout.println("<h1>"+rs.getString(2)+"</h1>");
		pout.println("<h1>"+rs.getInt(3)+"</h1>");
		pout.println("<h1>"+rs.getInt(4)+"</h1>");
		pout.println("<h1>"+rs.getString(5)+"</h1>");
	}
	}
 catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
