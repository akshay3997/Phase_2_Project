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
@WebServlet("/ClassSubDetails")
public class ClassSubDetails extends HttpServlet {
private Connection con;
private Statement cstmt;
private ResultSet res;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		PrintWriter writer = resp.getWriter();
		
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy", "root", "root");
		String sql = "select * from ClassSubject";
		 cstmt = con.createStatement();
		 res = cstmt.executeQuery(sql);
		
		 writer.println("<table border=1><th>ID</th><th>Class Name</th><th>Subject_1</th><th>Subject_2</th><th>Subject_3</th><th>Subject_4</th><th>Subject_5</th><th>Subject_6</th>");
		  writer.println("Class And Subjects Details");
		 while(res.next()==true) {
			 writer.println("<tr><td>"+res.getInt(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td>"
			 		+ "<td>"+res.getString(4)+"</td><td>"+res.getString(5)+"</td><td>"+res.getString(6)+"</td>"
			 				+ "<td>"+res.getString(7)+"</td><td>"+res.getString(8)+"</td></tr>");

				
		 }
		con.close();
		cstmt.close();
		 
	}
	catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
