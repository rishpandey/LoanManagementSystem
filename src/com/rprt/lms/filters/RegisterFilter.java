package com.rprt.lms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.rprt.lms.beans.User;

/**
 * Servlet Filter implementation class RegisterFilter
 */
public class RegisterFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public RegisterFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("HTML OUT : "+request.getParameter("username"));
		
		User user = new User(request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("emailid"),
				request.getParameter("number"),
				request.getParameter("security"),
				request.getParameter("answer"));
		
		request.setAttribute("user", user);

		System.out.println(user.toString());
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
