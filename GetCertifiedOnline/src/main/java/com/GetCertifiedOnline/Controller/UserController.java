package com.GetCertifiedOnline.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GetCertifiedOnline.Entity.User;
import com.GetCertifiedOnline.Exception.UserNotFoundException;
import com.GetCertifiedOnline.Service.UserServiceImpl;



@CrossOrigin("*")
@RestController()
@RequestMapping("/user")
@Validated
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired(required = true)
	UserServiceImpl userservice;


	@PostMapping("/Userlogin")
	public ResponseEntity<String> userLogin(@Valid @RequestParam("username") String username,
			@RequestParam("password") String password)
	{
		logger.trace("Entering into method userLogin");

		List<User> user = userservice.loginUser(username,password);
		if(user.isEmpty())
		{
			logger.info("Login successful ..");
			return new ResponseEntity<String>("Login Unsuccessfull", HttpStatus.NOT_FOUND);
		}

		logger.error("Error: Enter correct username and password..");
		return new ResponseEntity<String>("Login Successfull", HttpStatus.OK);
	}

	@PostMapping("/UserRegistration")
	public ResponseEntity<User> UserRegistration(@RequestBody User user) throws UserNotFoundException {
		User str = userservice.UserRegistration(user);
		return new ResponseEntity<User>(str, HttpStatus.CREATED);
	}
}