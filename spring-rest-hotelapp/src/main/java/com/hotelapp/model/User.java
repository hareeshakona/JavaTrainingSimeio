package com.hotelapp.model;

import java.time.LocalDate;

public class User {

	private Integer userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String city;
	private String emailId;
	private String securityQuestion;
	private String securityAnswer;
	private String userName;
	private String password;

	public User() {
		super();
	}

	public User(String firstName, String middleName, String lastName, LocalDate dateOfBirth, String city,
			String emailId, String securityQuestion, String securityAnswer) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.emailId = emailId;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public User(Integer userId, String firstName, String middleName, String lastName, LocalDate dateOfBirth,
			String city, String emailId, String securityQuestion, String securityAnswer, String userName,
			String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.emailId = emailId;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.userName = userName;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", city=" + city + ", emailId=" + emailId
				+ ", securityQuestion=" + securityQuestion + ", securityAnswer=" + securityAnswer + ", userName="
				+ userName + ", password=" + password + "]";
	}

}
