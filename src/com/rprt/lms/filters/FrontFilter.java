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
 * Servlet Filter implementation class UserFilter
 */
public class FrontFilter implements Filter {

    /**
     * Default constructor. 
     */
    public FrontFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
			User user=new User(request.getParameter("name"),request.getParameter("password"));
	    	 request.setAttribute("user",user);
	    	 System.out.println("in else of filter");
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
