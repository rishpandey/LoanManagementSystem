package com.rprt.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rprt.lms.beans.Loan;
import com.rprt.lms.beans.User;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.ServicesProvider;
import com.rprt.lms.services.LoanServices;


public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApplicationServlet() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Loan loan = (Loan) request.getAttribute("loan");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		 
		try {
			LoanServices service = ServicesProvider.getBankServices();
		
		if (service.application(Loan.getLoanFileNumber(),loan.getFirstName(), loan.getLastName(), loan.getCustomerAge(), loan.getLoanType(),loan.getInterestRate(), loan.getGender(),loan.getCustomerAddress(),loan.getCustomerOccupation(),loan.getCustomerIncome(),loan.getLoanAmount(),loan.getLoanTenure(),loan.getDate(),(String)session.getAttribute("username")))
			getServletContext().getRequestDispatcher("/afterapplicationform.html")
					.forward(request, response);
		else {
			getServletContext().getRequestDispatcher("/applicationform.html")
					.include(request, response);
			out.print("Invalid Details");
		}
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
