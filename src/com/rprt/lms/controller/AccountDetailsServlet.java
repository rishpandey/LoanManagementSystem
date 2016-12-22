package com.rprt.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rprt.lms.beans.Loan;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.ServicesProvider;
import com.rprt.lms.services.LoanServices;

/**
 * Servlet implementation class AccountDetailsServlet
 */
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		ArrayList<Loan> list = null;
		try {
			LoanServices service = ServicesProvider.getBankServices();
			list = service.accountSummary(username);
			
			session.setAttribute("list", list);
			getServletContext().getRequestDispatcher("/DisplayDetails.jsp").forward(request,response);
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
