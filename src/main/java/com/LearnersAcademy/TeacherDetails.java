package com.LearnersAcademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/TeacherDetails")
public class TeacherDetails extends HttpServlet{
private Connection con;
private PreparedStatement pstmt;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s1 = req.getParameter("Tid");
	int Tid = Integer.parseInt(s1);
	String s2 = req.getParameter("FirstName");
	String s3 = req.getParameter("LastName");
	String s4 = req.getParameter("PhoneNumber");
    long PN = Long.parseLong(s4);
	try {
		PrintWriter writer = resp.getWriter();
		
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy","root","root");
		String sql = "insert into Teacher values(?,?,?,?)";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, Tid);
		 pstmt.setString(2, s2);
		 pstmt.setString(3, s3);
		 pstmt.setLong(4, PN);
		 
		 int x = pstmt.executeUpdate();
		 if(x>0) {
			 resp.sendRedirect("Welcome.html");
		 }
		 else {
			 resp.sendRedirect("Failure.html");
		 }
		con.close();
		pstmt.close();
		
	} 
	
	catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
