package com.triveratech.jee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Hello, World, Servlet-style
 */
@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<h1>Hello, World!</h1>");
		response.getWriter().append("(From Servlet) <br/>");
		
		response.getWriter().append("Rendered at: " + new java.util.Date());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String userName = request.getParameter("userName");
 		String userPass = request.getParameter("userPass");
 		PrintWriter out = response.getWriter();
		System.out.println("User '" + userName + "' logged in with a password of '" + userPass );
 		response.setContentType("text/html");
 		out.println("<h1>Hello, " + userName + "</h1>");
 		out.flush();
 		out.close();
 	}

}
