package com.rprt.lms.services;

import java.util.ArrayList;

import com.rprt.lms.beans.Loan;

public interface LoanServices {
	
	public boolean validate(String username,String password);
	public	int registration(String username,String password,String email,String mobNo,String secQ,String secA);
	
	public int fullClosure(Integer loanFileId,Integer amount,int payAmount);
	public int partialClosure(Integer loanFileId,Integer amount,int payAmount);
	public int payEmi(Integer loanFileId,Integer amount,int payAmount);
	public ArrayList<Loan> accountSummary(String username);
	
	public double interstRate(String loanType);
	public boolean application(int loanFileNumber, String firstName,
			String lastName, int customerAge, String loanType,
			double interestRate, String gender, String customerAddress,
			String customerOccupation, int customerIncome, double loanAmount,
			int loanTenure, String date, String username);
	public boolean questionCheck(String username,String security,String answer,String newPassword);
		
}
