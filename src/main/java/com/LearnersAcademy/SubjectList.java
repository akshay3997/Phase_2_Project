package com.LearnersAcademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SubjectList")
public class SubjectList extends HttpServlet {
private Connection con;
private Statement cstmt;
private ResultSet res;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter writer = resp.getWriter();
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy", "root", "root");
	 String sql = "select * from Subject";
	  cstmt = con.createStatement();
	   res = cstmt.executeQuery(sql);
	   writer.println("<table border=1><th>ID</th><th>Subject Name</th>");
		  writer.println("Subject List");
		 while(res.next()==true) {
			 writer.println("<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td></tr>");

				
		 }
	} 
	catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
