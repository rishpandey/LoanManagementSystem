package com.rprt.lms.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rprt.lms.DAOInterface.DAOService;
import com.rprt.lms.beans.Loan;
import com.rprt.lms.exceptions.ServiceNotFoundException;
import com.rprt.lms.providers.DBUtil;

public class DAOServiceImpl implements DAOService {

	public boolean loginValidate(String uName, String password)
			throws SQLException {
		boolean flag = false;
		try {
			Connection connection = DBUtil.getConnection();
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
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean passwordUpdate(String username, String securityQues,
			String securityAns, String newPassword) throws SQLException {
		boolean flag = false;

		String ans = null;
		try {
			Connection connection = DBUtil.getConnection();
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

		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public int regInsert(String uName, String password, String email,
			String mobile_no, String securityQues, String securityAns) {
		int flag = 0;
		Connection connection = null;
		System.out.println(uName);
		try {
			connection = DBUtil.getConnection();
			String query = "select * from users where username=?";
			PreparedStatement smt = connection.prepareStatement(query);
			smt.setString(1, uName);
			ResultSet rs = smt.executeQuery();
			if (!rs.next()) {
				query = "insert into users values(?,?,?,?,?,?)";
				smt = connection.prepareStatement(query);
				smt.setString(1, uName);
				smt.setString(2, password);
				smt.setString(3, email);
				smt.setString(4, mobile_no);
				smt.setString(5, securityQues);
				smt.setString(6, securityAns);
				if (smt.executeUpdate() > 0) {
					flag = 1;
					System.out.println("Inserted");
				} else
					flag = 2; // not inserted due to sql error
			} else {
				flag = 3; // user exists
			}
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public boolean appInsert(int loanFileId, String firstName, String lastName,
			int customerAge, String loanType, double interestRate,
			String gender, String address, String occupation,
			int customerIncome, double loanAmount, int loanTenure, String date, String username)
			throws SQLException {
		Connection connection = null;
		boolean flag = false;
		try {
			connection = DBUtil.getConnection();
			String query = "insert into loan values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement smt = connection.prepareStatement(query);
			smt.setInt(1, loanFileId);
			smt.setString(2, loanType);
			smt.setInt(3, loanTenure);
			smt.setDouble(4, interestRate);
			smt.setDouble(5, loanAmount);
			smt.setString(6, date);
			smt.setString(7, firstName);
			smt.setString(8, lastName);
			smt.setInt(9, customerAge);
			smt.setString(10, address);
			smt.setString(11, occupation);
			smt.setInt(12, customerIncome);
			smt.setString(13, gender);
			smt.setString(14, username);
			smt.setDouble(15, loanAmount);
			if (smt.executeUpdate() > 0)
				flag = true;
			else
				flag = false;
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public boolean updateLoanAmount(int loanFileId, int amount) {
		Connection connection;
		try {
			connection = DBUtil.getConnection();
			PreparedStatement smt = connection
					.prepareStatement("update loan set loanamount=? where loanfilenumber=?;");
			smt.setInt(1, amount);
			smt.setInt(2, loanFileId);
			if (smt.execute())
				return true;
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public ArrayList<Loan> displayAccDetails(String username) throws SQLException {
		ArrayList<Loan> array = new ArrayList<Loan>();
		try {
			Connection connection = DBUtil.getConnection();
			System.out.println(username);
			PreparedStatement smt = connection
					.prepareStatement("select * from loan where customer_username=?");
			smt.setString(1, username);
			ResultSet rs = smt.executeQuery();
			while(rs.next()){
			array.add(new Loan(rs.getString(2), rs.getInt(3), rs.getDouble(4),
					rs.getDouble(5), rs.getString(10), rs.getString(7),
					rs.getString(8), rs.getInt(9), rs.getString(13),
					rs.getString(11), rs.getInt(12), rs.getString(6)));
			}
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	
}
