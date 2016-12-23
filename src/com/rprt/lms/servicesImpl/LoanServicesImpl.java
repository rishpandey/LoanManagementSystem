package com.rprt.lms.servicesImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rprt.lms.DAOImpl.DAOServiceImpl;
import com.rprt.lms.beans.Loan;
import com.rprt.lms.beans.User;
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

	public boolean validate(String username, String password)
			throws ServiceNotFoundException, NullPointerException {
		boolean flag = false;
		try {
			if (dao.loginValidate(username, password))
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			throw new ServiceNotFoundException();
		}
		return flag;
	}

	public int registration(User user) {
		int flag = dao.regInsert(user);
		return flag;
	}

	public int fullClosure(int loanFileId, int amount, int payAmount)
			throws ServiceNotFoundException {
		int balance = amount - payAmount;
		try {
			dao.updateLoanAmount(loanFileId, balance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceNotFoundException(
					" sql exception in full closure ");
		}

		return balance;
	}

	public int partialClosure(Integer loanFileId, Integer amount, int payAmount)
			throws ServiceNotFoundException {
		int balance = amount - payAmount;
		try {
			dao.updateLoanAmount(loanFileId, balance);
		} catch (SQLException e) {
			throw new ServiceNotFoundException(
					" sql exception in partial closure ");
		}
		return balance;
	}

	public double payEmi(Integer loanFileId, double amount, double payAmount)
			throws ServiceNotFoundException {
		double balance = amount - payAmount;
		try {
			dao.updateLoanAmount(loanFileId, balance);
		} catch (SQLException e) {
			throw new ServiceNotFoundException(" sql exception in pay Emi ");
		}
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

	public boolean application(Loan loan, String username) {
		boolean flag = false;
		try {
			if (dao.appInsert(loan, username))
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	public boolean questionCheck(String username, String securityQues,
			String answer, String newPassword) throws ServiceNotFoundException {
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
