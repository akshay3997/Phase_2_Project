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
@WebServlet("/Check")
public class Check  extends HttpServlet{
private Connection con;
private Statement cstmt;
private ResultSet res;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		PrintWriter writer = resp.getWriter();
		
		Class.forName("com.mysql.jdbc.Driver");
		
 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy","root","root");

		String sql = "select * from NewClassSubject";
		 cstmt = con.createStatement();
		  res = cstmt.executeQuery(sql);
		 
		  writer.println("<table border=1><th>Class Name</th><th>Subject_1</th><th>Subject_2</th><th>Subject_3</th>");
		  writer.println("Details of Subject related to Class");
		 while(res.next()==true) {
			 writer.println("<tr><td>"+res.getString(1)+"</td><td>"+res.getString(2)+"</td><td>"+res.getString(3)+"</td><td>"+res.getString(4)+"</td></tr>");

				
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
