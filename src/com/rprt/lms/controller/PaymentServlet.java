package com.rprt.lms.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ArrayList<Loan> list = (ArrayList) session.getAttribute("list");
		
		Loan loan = null;
		if (request.getParameter("hidden").equals("emi")) {
			try {
				LoanServices service = ServicesProvider.getBankServices();
				service.payEmi(loan.getLoanFileNumber(), loan.getRemaining_amount(), loan.getEMI());
				getServletContext().getRequestDispatcher("/DisplayAccountDetails.jsp");
				response.getWriter().println("Emi Paid");
				
			} catch (ServiceNotFoundException e) {
				throw new ServletException();
			}
		}

		else if (request.getParameter("hidden").equals("partial")) {
			getServletContext().getRequestDispatcher("/partialpay.jsp");
		}

		else if (request.getParameter("hidden").equals("complete")) {
			getServletContext().getRequestDispatcher("/pay.jsp");
		}
	}

}
