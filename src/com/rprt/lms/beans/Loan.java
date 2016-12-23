package com.rprt.lms.beans;

import java.text.DecimalFormat;
import java.util.Date;

public class Loan {
	private static int serial = 100000;
	private int loanFileNumber = 0;
	private String loanType = null;
	private int loanTenure = 0;
	private double interestRate = 0;
	private double loanAmount = 0;
	private String customerAddress = null;
	private String firstName = null;
	private String lastName = null;
	private int customerAge = 0;
	private String gender = null;
	private String customerOccupation = null;
	private int customerIncome = 0;
	private String date = null;
	private double remaining_amount = 0;

	public Loan() {
		super();
	}

	public Loan(String loanType, int loanTenure, double interestRate,
			double loanAmount, String customerAddress, String firstName,
			String lastName, int customerAge, String gender,
			String customerOccupation, int customerIncome, String date, double remaining_amount) {
		super();
		this.loanFileNumber = serial;
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
		this.date = date;
		this.remaining_amount = remaining_amount;
		

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
		serial++;
		this.loanFileNumber = serial;
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
		this.remaining_amount = loanAmount;
		
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

	
	
	public double getRemaining_amount() {
		return remaining_amount;
	}

	public void setRemaining_amount(double remaining_amount) {
		this.remaining_amount = remaining_amount;
	}

	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getLoanFileNumber() {
		return loanFileNumber;
	}

	public void setLoanFileNumber(int loanFileNumber) {
		this.loanFileNumber = loanFileNumber;
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
		 double temp = this.interestRate / 1200 ;
		 double emi = this.loanAmount * temp * (Math.pow((1 + temp), this.loanTenure)) / (Math.pow((1 + temp), this.loanTenure) - 1);
		 DecimalFormat df = new DecimalFormat("#.00");
		 return Double.parseDouble(df.format(emi));
	}

	@Override
	public String toString() {
		return "Loan [loanType=" + loanType + ", loanTenure=" + loanTenure
				+ ", interestRate=" + interestRate + ", loanAmount="
				+ loanAmount + ", customerAddress=" + customerAddress
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", customerAge=" + customerAge + ", gender=" + gender
				+ ", customerOccupation=" + customerOccupation
				+ ", customerIncome=" + customerIncome + ", date=" + date
				+ ", remaining_amount=" + remaining_amount + "]";
	}
}
