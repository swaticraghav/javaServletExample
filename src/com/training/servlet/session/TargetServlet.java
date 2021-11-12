package com.training.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/TargetServlet")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// cookie part starts here
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println("Target Name: " + cookies[i].getName());
			System.out.println("Target Value: " + cookies[i].getValue());
		}
		
		// cookie part ends here
		
		
		// we are using doGet method as this servlet is called on click of a hyperlink.
		
		// create the session
		HttpSession session = request.getSession();
		
		// get the user name from the ongoing session
		String userName = (String) session.getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// print the information obtained from the ongoing session
		out.println("<h1>User name is </h1>" + userName);
	}



}
