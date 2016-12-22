package com.rprt.lms.DAOInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rprt.lms.beans.Loan;

public interface DAOService {
	public boolean loginValidate(String uName,String password) throws SQLException;
	
	public boolean passwordUpdate(String username, String securityQues,String securityAns, String newPassword)throws SQLException;
	
	public int regInsert(String uName,String password,String email,String mobile_no,String securityQues,String securityAns) throws SQLException;
	
	public boolean appInsert(int loanFileNumber,String firstName,String lastName,int customerAge,String loanType,double interestRate,String gender,String address,String occupation,int customerIncome,double loanAmount,int loanTenure,String date, String username) throws SQLException;
	
	public boolean updateLoanAmount( int loanFileId,int amount);
	
	public ArrayList<Loan> displayAccDetails(String username) throws SQLException;
	
}
