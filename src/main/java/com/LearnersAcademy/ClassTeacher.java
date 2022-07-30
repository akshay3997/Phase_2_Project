package com.LearnersAcademy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ClassTeacher")
public class ClassTeacher extends HttpServlet{
private Connection con;
private PreparedStatement pstmt;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s1 = req.getParameter("Class");
	String s2 = req.getParameter("Teacher");
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy", "root", "root");
		String sql = "insert into ClassTeacher values(?,?)";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, s1);
		 pstmt.setString(2,s2);
		
		 int x = pstmt.executeUpdate();
		 if(x>0) {
			 resp.sendRedirect("Success.html");
		 }
		 else {
			 resp.sendRedirect("Failure.html");
		 }
	} 
	catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
