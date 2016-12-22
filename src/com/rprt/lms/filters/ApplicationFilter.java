package com.rprt.lms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.rprt.lms.beans.Loan;

/**
 * Servlet Filter implementation class ApplicationFilter
 */
public class ApplicationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ApplicationFilter() {
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
		Loan loan = new Loan(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("gender"), request.getParameter("address"), Integer.parseInt(request.getParameter("tenure")), request.getParameter("occupation"), Integer.parseInt(request.getParameter("income")), Double.parseDouble(request.getParameter("loanamt")), request.getParameter("loanType"), Integer.parseInt(request.getParameter("age")));
		request.setAttribute("loan",loan);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
