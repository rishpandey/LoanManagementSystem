package com.rprt.lms.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rprt.lms.DAOInterface.DAOService;
import com.rprt.lms.beans.Loan;
import com.rprt.lms.beans.User;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.DBUtil;

public class DAOServiceImpl implements DAOService {
	Connection connection = null;

	public DAOServiceImpl() throws ServiceNotFoundException {
		super();
		connection = DBUtil.getConnection();
	}

	public boolean loginValidate(String uName, String password)
			throws SQLException {
		boolean flag = false;
		PreparedStatement smt = connection
				.prepareStatement("select * from users where username=? and password=?");
		smt.setString(1, uName);
		smt.setString(2, password);
		ResultSet rs = smt.executeQuery();
		if (rs.next()) {
			flag = true;
			System.out.println("Entry exists");
		} else {
			flag = false;
			System.out.println("Entry not found.");
		}
		return flag;
	}

	public boolean passwordUpdate(String username, String securityQues,
			String securityAns, String newPassword) throws SQLException,
			ServiceNotFoundException {
		boolean flag = false;

		String ans = null;
		String query = "select securityanswer from users where securityquestion=? and username=?;";
		PreparedStatement smt = connection.prepareStatement(query);
		smt.setString(1, securityQues);
		smt.setString(2, username);
		ResultSet rs = smt.executeQuery();
		if (rs.next()) {
			ans = rs.getString(1);
			if (ans.equals(securityAns)) {
				query = "update users set password=? where username=?;";
				smt = connection.prepareStatement(query);
				smt.setString(1, newPassword);
				smt.setString(2, username);
				if (smt.executeUpdate() > 0) {
					flag = true;
				}
			}
		} else
			flag = false;
		return flag;
	}

	public int regInsert(User user) {
		int flag = 0;
	//	System.out.println(uName);
		try {
			String query = "select * from users where username=?";
			PreparedStatement smt = connection.prepareStatement(query);
			smt.setString(1,user.getUsername());
			ResultSet rs = smt.executeQuery();
			if (!rs.next()) {
				query = "insert into users values(?,?,?,?,?,?)";
				smt = connection.prepareStatement(query);
				smt.setString(1, user.getUsername());
				smt.setString(2, user.getPassword());
				smt.setString(3, user.getEmail());
				smt.setString(4, user.getMobile());
				smt.setString(5,user.getSecurityQuestion());
				smt.setString(6, user.getAnswer());
				if (smt.executeUpdate() > 0) {
					flag = 1;
					System.out.println("Inserted");
				} else
					flag = 2; // not inserted due to sql error
			} else {
				flag = 3; // user exists
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public boolean appInsert(Loan loan,	String username) throws SQLException {
		boolean flag = false;
		String query = "insert into loan values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement smt = connection.prepareStatement(query);
		smt.setInt(1, loan.getLoanFileNumber());
		smt.setString(2, loan.getLoanType());
		smt.setInt(3, loan.getLoanTenure());
		smt.setDouble(4, loan.getInterestRate());
		smt.setDouble(5, loan.getLoanAmount());
		smt.setString(6, loan.getDate());
		smt.setString(7, loan.getFirstName());
		smt.setString(8, loan.getLastName());
		smt.setInt(9, loan.getCustomerAge());
		smt.setString(10, loan.getCustomerAddress());
		smt.setString(11, loan.getCustomerOccupation());
		smt.setInt(12, loan.getCustomerIncome());
		smt.setString(13, loan.getGender());
		smt.setString(14, username);
		smt.setDouble(15, loan.getLoanAmount());
		if (smt.executeUpdate() > 0)
			flag = true;
		else
			flag = false;

		return flag;
	}

	public boolean updateLoanAmount(int loanFileId, double balance)
			throws SQLException {
		PreparedStatement smt = connection
				.prepareStatement("update loan set remaining_amount=? where loanfilenumber=?;");
		smt.setDouble(1, balance);
		smt.setInt(2, loanFileId);
		if (smt.execute())
			return true;
		else
			return false;
	}

	public ArrayList<Loan> displayAccDetails(String username)
			throws SQLException {
		ArrayList<Loan> array = new ArrayList<Loan>();
		System.out.println(username);
		PreparedStatement smt = connection
				.prepareStatement("select * from loan where customer_username=?");
		smt.setString(1, username);
		ResultSet rs = smt.executeQuery();
		while (rs.next()) {
			array.add(new Loan(rs.getString(2), rs.getInt(3), rs.getDouble(4),
					rs.getDouble(5), rs.getString(10), rs.getString(7), rs
							.getString(8), rs.getInt(9), rs.getString(13), rs
							.getString(11), rs.getInt(12), rs.getString(6), rs
							.getDouble(15)));
		}
		return array;
	}


}
