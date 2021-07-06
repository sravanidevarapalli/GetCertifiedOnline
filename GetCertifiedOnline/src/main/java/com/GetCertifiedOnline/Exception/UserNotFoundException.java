package com.GetCertifiedOnline.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserNotFoundException extends Exception{

	
private static final Logger logger = LoggerFactory.getLogger(UserNotFoundException.class);
	
	public UserNotFoundException() {
		
	}
	public UserNotFoundException(String msg) {
		
		super(msg);
		logger.info("Inside UserNotFoundException");
	}

}