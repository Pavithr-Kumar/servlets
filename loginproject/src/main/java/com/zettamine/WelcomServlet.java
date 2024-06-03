package com.zettamine;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class WelcomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.isNew()) {
			
			//response.sendRedirect("login.html");
		}else {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Zettamine Labs Private Limited</h1>");
			out.println("<img style=\"width: 400px;\" src=\"https://assets.thehansindia.com/hansindia-bucket/NIT_1280.jpg\">");
			out.println("<h3> Hello "+session.getAttribute("user")+" !!</h3>");
			out.println("</body>");
			out.println("</html>");
		}
			
	}

	
}
