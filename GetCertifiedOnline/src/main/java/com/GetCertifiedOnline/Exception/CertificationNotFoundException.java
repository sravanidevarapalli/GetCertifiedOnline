package com.GetCertifiedOnline.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CertificationNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CertificationNotFoundException.class);
	public CertificationNotFoundException() {
	}
	
	public CertificationNotFoundException(String msg) {
		
		super(msg);
		logger.info("Inside CertificationNotFoundException");
	}
	}
