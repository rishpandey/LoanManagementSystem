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
				getServletContext().getRequestDispatcher("/login.html")
						.include(request, response);
				out.print("Incorrect Login Details");
			}
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
