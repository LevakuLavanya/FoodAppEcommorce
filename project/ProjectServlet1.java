package com.jsp.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/insert1")
public class ProjectServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name= req.getParameter("name");
		String yop= req.getParameter("yop");
		String age = req.getParameter("age");
		String mobileno = req.getParameter("mobileno");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Root");
			PreparedStatement ps = con.prepareStatement("insert into prostudent(id,name,yop,age,mobileno) values(?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2,name);
			ps.setInt(3, Integer.parseInt(yop));
			ps.setInt(4, Integer.parseInt(age));
			ps.setString(5, mobileno);
			ps.execute();
			PrintWriter pout = resp.getWriter();
			pout.print("<h1>Inserted</h1>");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
