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
@WebServlet("/updatepro")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String upid = req.getParameter("upid");
		String id = req.getParameter("id");
	String name = req.getParameter("name");
	String yop = req.getParameter("yop");
	String age = req.getParameter("age");
	String mobileno = req.getParameter("mobileno");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Root");
		PreparedStatement ps = con.prepareStatement("update prostudent set id = ?,name = ?,yop=?,age=?,mobileno=? where id = ?");
		ps.setInt(1, Integer.parseInt(id));
	    ps.setString(2, name);
	    ps.setInt(3,Integer.parseInt(yop));
	    ps.setInt(4, Integer.parseInt(age));
	   ps.setLong(5, Long.parseLong(upid));
	   ps.setInt(6,Integer.parseInt(upid));
	    ps.execute();
	    PrintWriter pout = resp.getWriter();
	    pout.println("<h1>updated success</h1>");
	}
	catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
