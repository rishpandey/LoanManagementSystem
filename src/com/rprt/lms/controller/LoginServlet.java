package com.rprt.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rprt.lms.beans.User;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.ServicesProvider;
import com.rprt.lms.services.LoanServices;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		PrintWriter out = response.getWriter();
		request.setAttribute("username", user.getUsername());
		try {
			LoanServices service = ServicesProvider.getBankServices();
			if (service.validate(user.getUsername(), user.getPassword())) {
				HttpSession session = request.getSession();
				getServletContext().getRequestDispatcher("/afterlogin.jsp")
						.forward(request, response);
			} else {
				request.setAttribute("error","Invalid username or password please try again");
		    	 getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (ServiceNotFoundException e) {
			throw new ServletException();
			
		}catch (NullPointerException e) {
			throw new ServletException();
			
		}
	}

}
