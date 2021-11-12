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
 * Servlet implementation class SourceServlet
 */
@WebServlet("/SourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// cookie part starts here
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println("Name: " + cookies[i].getName());
				System.out.println("Value: " + cookies[i].getValue());
			}
		}
		// cookie part ends here

		// adding of cookie starts here
		response.addCookie(new Cookie("color", "pink"));

		// adding of cookie ends here

		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("user", userName);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String urlReWriting = "TargetServlet?sessionId=123";
		out.println("<a href='" + urlReWriting + "'" + "> Click here to get the user name. </a>");

	}

}
