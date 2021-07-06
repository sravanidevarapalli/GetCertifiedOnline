package com.GetCertifiedOnline.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="Admin_Login")
public class AdminLogin {
@Id

@Column(name="mail_Id")
private String mailId;
@Column(name="userName")
@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Customer_seq")
@SequenceGenerator(name="Customer_seq",sequenceName="Customer_seq", allocationSize=1)
@NotBlank(message = "Name is required")
@Pattern(regexp="(?:[A-Z][a-z.-]+[ ]?)+",message="Enter Valid Name. Starting Letter Should Be Capital And White Spaces Are Allowed")
private String userName;
@Column(name="password")
@NotBlank(message = "Password is required")
private String password;
public AdminLogin() {
	
}
public AdminLogin(String mailId,
		@NotBlank(message = "Name is required") @Pattern(regexp = "(?:[A-Z][a-z.-]+[ ]?)+", message = "Enter Valid Name. Starting Letter Should Be Capital And White Spaces Are Allowed") String userName,
		@NotBlank(message = "Password is required") String password) {
	super();
	this.mailId = mailId;
	this.userName = userName;
	this.password = password;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
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
	return "AdminLogin [mailId=" + mailId + ", userName=" + userName + ", password=" + password + ", getMailId()="
			+ getMailId() + ", getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getClass()="
			+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}



/*
public Customer get() {
	// TODO Auto-generated method stub
	return null;
}
*/
}
