package com.zettamine;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;


@WebFilter("/filter")
public class MyFilter extends HttpFilter implements Filter {
       
    
    public MyFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String user = request.getParameter("username");
		String pass =request.getParameter("password");
		if(user.equals("admin")&&pass.equals("admin")) {
			System.out.println("if in ....do filter");
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
			chain.doFilter(request, response);
		}
		else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			out.println("<h1 style=color:red;>Invalid details try again</h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
			System.out.println("Else executed");
		}
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
