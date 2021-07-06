package com.GetCertifiedOnline.Exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CourseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CourseNotFoundException.class);
	public CourseNotFoundException() {
		
	}
	public CourseNotFoundException(String msg) {
		super(msg);
		logger.info("Inside CourseNotFoundException");
		}
}
