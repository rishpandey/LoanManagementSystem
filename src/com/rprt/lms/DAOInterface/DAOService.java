package com.rprt.lms.DAOInterface;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rprt.lms.beans.Loan;
import com.rprt.lms.beans.User;
import com.rprt.lms.exceptions.ServiceNotFoundException;

public interface DAOService {
	public boolean loginValidate(String uName,String password) throws SQLException;
	
	public boolean passwordUpdate(String username, String securityQues,String securityAns, String newPassword)throws SQLException, ServiceNotFoundException;
	
	public int regInsert(User user) throws SQLException;
	public boolean appInsert(Loan loan, String username) throws SQLException;
	
	public boolean updateLoanAmount( int loanFileId,double amount) throws SQLException;
	
	public ArrayList<Loan> displayAccDetails(String username) throws SQLException;
	
}
