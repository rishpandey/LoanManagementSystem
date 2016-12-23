package com.rprt.lms.services;

import java.util.ArrayList;

import com.rprt.lms.beans.Loan;
import com.rprt.lms.beans.User;
import com.rprt.lms.exceptions.ServiceNotFoundException;

public interface LoanServices {
	
	public boolean validate(String username,String password) throws ServiceNotFoundException;
	public	int registration(User user);
	
	public int fullClosure(Integer loanFileId,Integer amount,int payAmount);
	public int partialClosure(Integer loanFileId,Integer amount,int payAmount) throws ServiceNotFoundException;
	public double payEmi(Integer loanFileId,double d,double e) throws ServiceNotFoundException;
	public ArrayList<Loan> accountSummary(String username);
	
	public double interstRate(String loanType);
	public boolean application(Loan loan, String username);
	public boolean questionCheck(String username,String security,String answer,String newPassword) throws ServiceNotFoundException;
		
}
