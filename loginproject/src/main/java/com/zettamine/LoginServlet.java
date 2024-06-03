package com.zettamine;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	 @Override
	public void init(ServletConfig config) throws ServletException {
		 try {
			 Class.forName("org.postgresql.Driver");
			 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_zettamine","postgres","Root@123");
			 
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("username");
		String pass =request.getParameter("password");
		String sql = "select * from users where name =? and pass=?;";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, pass);
			RequestDispatcher rd;
			ResultSet set = pst.executeQuery();
			if(set.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
//				 rd = request.getRequestDispatcher("welcome");
//				 rd.include(request, response);
				//response.sendRedirect(request.getContextPath()+"welcome");
				response.sendRedirect("welcome");
				
			}else {
				System.out.println("Else block");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h2> Invalid login details !! Try again</h2>");
				rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
