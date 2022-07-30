package com.LearnersAcademy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/AddDetails")
public class AddDetails extends HttpServlet {
private Connection con;
private PreparedStatement pstmt;

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s1 = req.getParameter("ClassID");
	int Cid= Integer.parseInt(s1);
	String s2 = req.getParameter("ClassName");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy","root","root");
		String sql = "insert into Class values(?,?)";
		 pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, Cid);
		 pstmt.setString(2, s2);
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
