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
 * Servlet implementation class ResetPassServlet
 */
public class ResetPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = (User) request.getAttribute("user");
		PrintWriter out = response.getWriter();
		try {
			LoanServices service = ServicesProvider.getBankServices();
			System.out.println("in servlet "+user);
			if (service.questionCheck(user.getUsername(), user.getSecurityQuestion(), user.getAnswer(),user.getNewpass()))
			{	getServletContext().getRequestDispatcher("/passchangesuccess.html")
						.forward(request, response);
				System.out.println("go to pass updated html");
			}
			else {
				getServletContext().getRequestDispatcher("/Forgotpass.html")
						.include(request, response);
				out.print("Incorrect Answer");
			}		
		
		} catch (ServiceNotFoundException e) {
			throw new ServletException();
		}
	}

}
