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


@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
private Statement cstmt;
private ResultSet res;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		PrintWriter writer = resp.getWriter();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Learnersacademy","root","root");
		String sql = "select * from student";
		 cstmt = con.createStatement();	
		  res = cstmt.executeQuery(sql);
		
		  writer.println("<table border=1><th>ID</th><th>First Name</th><th>Last Name</th><th>Phone Number</th><th>Class</th>");
		  writer.println("Student Details");
		 while(res.next()==true) {
//			 writer.println(res.getInt(1)+"---->"+res.getString(2)+"---->"+res.getString(3)+"---->"+res.getLong(4)+"---->"+res.getString(5));
			writer.println("<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getLong(4)+"</td><td>"+res.getString(5)+"</td></tr>");

			
		 }
		  writer.println("</table>");
		 
		
		 //resp.sendRedirect("ShowStudents.html");
		 con.close();
		 cstmt.close();
	} 
	catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
