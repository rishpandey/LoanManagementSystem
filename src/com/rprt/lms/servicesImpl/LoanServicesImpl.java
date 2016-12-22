package com.rprt.lms.servicesImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rprt.lms.DAOImpl.DAOServiceImpl;
import com.rprt.lms.beans.Loan;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.DAOServicesProvider;
import com.rprt.lms.services.LoanServices;

public class LoanServicesImpl implements LoanServices {

	DAOServiceImpl dao = null;

	public LoanServicesImpl() {
		super();
		try {
			dao = (DAOServiceImpl) DAOServicesProvider.getDAOServices();
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validate(String username, String password) {
		boolean flag = false;
		try {
			if (dao.loginValidate(username, password))
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public int registration(String username, String password, String email,
			String mobNo, String secQ, String secA) {
		int flag = dao.regInsert(username, password, email, mobNo, secQ, secA);
		return flag;
	}

	public int fullClosure(int loanFileId, int amount, int payAmount) {
		int balance = amount - payAmount;
		dao.updateLoanAmount(loanFileId, balance);

		return balance;
	}

	public int partialClosure(Integer loanFileId, Integer amount, int payAmount) {
		int balance = amount - payAmount;
		dao.updateLoanAmount(loanFileId, balance);
		return balance;
	}

	public int payEmi(Integer loanFileId, Integer amount, int payAmount) {
		int balance = amount - payAmount;
		dao.updateLoanAmount(loanFileId, balance);
		return balance;
	}

	public double emiCalculation(double interest, int amount, int tenure) {
		return (amount * interest * (1 + interest)) / tenure;

	}

	public ArrayList<Loan> accountSummary(String username) {
		try {
			return dao.displayAccDetails(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public double interstRate(String loanType) {
		double interest;
		if (loanType.equals("personalloan")) {
			interest = 9.10;

		} else if (loanType.equals("educationloan")) {
			interest = 9.40;

		} else if (loanType.equals("homeloan")) {
			interest = 9.50;

		} else {
			interest = 9.20;

		}

		return interest;

	}

	

	public int fullClosure(Integer loanFileId, Integer amount, int payAmount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean application(int loanFileNumber, String firstName,
			String lastName, int customerAge, String loanType,
			double interestRate, String gender, String customerAddress,
			String customerOccupation, int customerIncome,
			double loanAmount, int loanTenure,String date, String username) {
		boolean flag = false;
		try {
			if(dao.appInsert( loanFileNumber, firstName,lastName,customerAge,loanType,interestRate,gender,customerAddress,customerOccupation,customerIncome,loanAmount,loanTenure,date, username)) flag = true;
			else flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
		}
	
	public boolean questionCheck(String username, String securityQues, String answer,String newPassword) {
		boolean flag = false;
		try {
			if (dao.passwordUpdate(username, securityQues, answer, newPassword))
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}
	
}
