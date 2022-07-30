package com.LearnersAcademy;


import java.io.IOException;
import java.io.PrintWriter;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/IdVerification")
public class IdVerification extends HttpServlet{


//Using post method 

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
String userId = req.getParameter("userID");
String password = req.getParameter("password");
//Admin useID and password
String userid="admin@learnersacademy.com";
String pass="1234";

if(userId.equalsIgnoreCase(userid)  && password.equalsIgnoreCase(pass) ) {
resp.sendRedirect("Welcome.html");

}
else {
	resp.sendRedirect("Invalid.html");
}
}


}