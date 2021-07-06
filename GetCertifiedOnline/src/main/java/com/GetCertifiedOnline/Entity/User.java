package com.GetCertifiedOnline.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import com.sun.istack.NotNull;


@Entity
@Table(name = "userlogin")

public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int user_id;

	@NotBlank(message = "Please enter user name")
	@Column(name="name")
	private String name;


	@NotBlank(message = "Please enter user name")
	@Column(name="username")
	@Size(min = 8,message="Username should be more than 7 characters ")
	private String username;

	@NotBlank(message = "Please enter password")
	@Column(name="user_password")
	@Size(min = 8,message="Password should be more than 7 characters ")
	private String password;


	@Size(min = 10, message="Mobile no should be in 10 digits")
	@Column(name = "phone",unique = true)
	private String phone_no;


	//@Email(message = "Email should be valid")
	@Column(name = "email",unique = true)
	@NotBlank(message = "Please enter a email id")
	private String email_id;

    public User() {

	}

    public int getUser_id() {
		return user_id;
	}


    public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


    public String getName() {
		return name;
	}


    public void setName(String name) {
		this.name = name;
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


    public String getPhone_no() {
		return phone_no;
	}


    public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}


    public String getEmail_id() {
		return email_id;
	}


    public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

    public User(int user_id, @NotBlank(message = "Please enter client name") String name,
			@NotBlank(message = "Please enter client name") @Size(min = 8, message = "Username should be more than 7 characters ") String username,
			@NotBlank(message = "Please enter password") @Size(min = 8, message = "Password should be more than 7 characters ") String password,
			@Size(min = 10, message = "Mobile no should be in 10 digits") String phone_no,
			@NotBlank(message = "Please enter a email id") String email_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone_no = phone_no;
		this.email_id = email_id;
	}

    @Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", phone_no=" + phone_no + ", email_id=" + email_id + "]";
	}


}




