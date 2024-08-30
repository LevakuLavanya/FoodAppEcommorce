package com.jsp.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deletepro")
public class DeletePro extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			resp.setContentType("text/html");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Root");
		PreparedStatement ps = con.prepareStatement("delete from prostudent where id = ?");
		ps.setInt(1,Integer.parseInt(id));
		int count=ps.executeUpdate();
		PrintWriter pout = resp.getWriter();
		pout.println(count);
		pout.println("<h1>"+count+"</h1>"+"<h1>deleted success</h1>");
		
	}
 catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
}
}