package com.rprt.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rprt.lms.beans.User;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.ServicesProvider;
import com.rprt.lms.services.LoanServices;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getAttribute("user");
		PrintWriter out = response.getWriter();
		System.out.println(user+" in the servlet");
		try {
			LoanServices service = ServicesProvider.getBankServices();
			int flag = service.registration(user.getUsername(),
					user.getPassword(), user.getEmail(), user.getMobile(),
					user.getSecurityQuestion(), user.getAnswer());
			if (flag == 1) {
				getServletContext().getRequestDispatcher(
						"/afterregistration.html").forward(request, response);
			} else if (flag == 2) {
				getServletContext().getRequestDispatcher("/register.html")
						.include(request, response);
				out.print("Incorrect Details");
			} else if (flag == 3) {
				getServletContext().getRequestDispatcher("/register.html")
						.include(request, response);
				out.print("Username Taken");
			} else {
				getServletContext().getRequestDispatcher("/register.html")
						.include(request, response);
				out.print("Unknown Error");
			}
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
