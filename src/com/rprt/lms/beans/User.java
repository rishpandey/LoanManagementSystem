package com.rprt.lms.beans;

public class User {
	private String username = null;
	private String password = null;
	private String email = null;
	private String mobile = null;
	private String securityQuestion = null;
	private String answer = null;
	private String newpass = null;
	
	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public User() {
		super();
	}
	
	public User(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, String email, String mobile,
			String securityQuestion, String answer) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}
	
	
	public User(String username, String securityQuestion, String answer,String newpass) {
		// TODO Auto-generated constructor stub
		super();
		this.username = username;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
		this.newpass = newpass;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", mobile=" + mobile
				+ ", securityQuestion=" + securityQuestion + ", answer="
				+ answer + ", newpass=" + newpass + "]";
	}
	
	
	

	
}
