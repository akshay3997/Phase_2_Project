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
@WebServlet("/ShowTeacher")
public class ShowTeacher extends HttpServlet {
private Connection con;
private Statement cstmt;
private ResultSet res;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		PrintWriter writer = resp.getWriter();
		
		Class.forName("com.mysql.jdbc.Driver");
		
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy","root","root");

		String sql = "select * from Teacher";
		 cstmt = con.createStatement();
		  res = cstmt.executeQuery(sql);
		 
		  writer.println("<table border=1><th>ID</th><th>First Name</th><th>Last Name</th><th>Phone Number</th>");
		  writer.println("Teachers Details");
		 while(res.next()==true) {
			 writer.println("<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getLong(4)+"</td></tr>");

				
		 }
		  writer.println("</table>");
//			 writer.println(res.getInt(1)+"---------"+res.getString(2)+"---------"+res.getString(3)+"---------"+res.getLong(4));
		 
		  
		  con.close();
		  cstmt.close();
		  
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
