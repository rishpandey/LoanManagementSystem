package com.rprt.lms.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {
	static int loanFileNumber = 10000;
	String loanType = null;
	int loanTenure = 0;
	double interestRate = 0;
	double loanAmount = 0;
	String customerAddress = null;
	String firstName = null;
	String lastName = null;
	int customerAge = 0;
	String gender = null;
	String customerOccupation = null;
	int customerIncome = 0;
	String date = null;

	public Loan() {
		super();
	}

	public Loan(String loanType, int loanTenure, double interestRate,
			double loanAmount, String customerAddress, String firstName,
			String lastName, int customerAge, String gender,
			String customerOccupation, int customerIncome, String date) {
		super();
		loanFileNumber++;
		this.loanType = loanType;
		this.loanTenure = loanTenure;
		this.interestRate = interestRate;
		this.loanAmount = loanAmount;
		this.customerAddress = customerAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerAge = customerAge;
		this.gender = gender;
		this.customerOccupation = customerOccupation;
		this.customerIncome = customerIncome;
		this.date = new Date().toString();
		

		if (loanType.equals("personalloan")) {
			this.interestRate = 9.10;

		} else if (loanType.equals("educationloan")) {
			this.interestRate = 9.40;

		} else if (loanType.equals("homeloan")) {
			this.interestRate = 9.50;

		} else {
			this.interestRate = 9.20;

		}

	}

	public Loan(String firstName, String lastName, String gender,
			String customerAddress, int loanTenure, String customerOccupation,
			int customerIncome, double loanAmount, String loanType,
			int CustomerAge) {
		super();
		loanFileNumber++;
		this.loanType = loanType;
		this.loanTenure = loanTenure;

		this.loanAmount = loanAmount;
		this.customerAddress = customerAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.customerAge = customerAge;
		this.gender = gender;
		this.customerOccupation = customerOccupation;
		this.customerIncome = customerIncome;
		this.date = new Date().toString();

		if (loanType.equals("personalloan")) {
			this.interestRate = 9.10;

		} else if (loanType.equals("educationloan")) {
			this.interestRate = 9.40;

		} else if (loanType.equals("homeloan")) {
			this.interestRate = 9.50;

		} else {
			this.interestRate = 9.20;

		}

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static int getLoanFileNumber() {
		return loanFileNumber;
	}

	public static void setLoanFileNumber(int loanFileNumber) {
		Loan.loanFileNumber = loanFileNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerOccupation() {
		return customerOccupation;
	}

	public void setCustomerOccupation(String customerOccupation) {
		this.customerOccupation = customerOccupation;
	}

	public int getCustomerIncome() {
		return customerIncome;
	}

	public void setCustomerIncome(int customerIncome) {
		this.customerIncome = customerIncome;
	}

	public String getString() {
		return date;
	}

	public void setString(String date) {
		this.date = date;
	}
	
	public double getEMI(){
		 return 0;
	}
	
	@Override
	public String toString() {
		return "Loan [loanType=" + loanType + ", loanTenure=" + loanTenure
				+ ", interestRate=" + interestRate + ", loanAmount="
				+ loanAmount + ", customerAddress=" + customerAddress
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerAge=" + customerAge + ", gender=" + gender
				+ ", customerOccupation=" + customerOccupation
				+ ", customerIncome=" + customerIncome + ", date=" + date + "]";
	}

}
