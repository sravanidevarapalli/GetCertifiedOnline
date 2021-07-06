package com.GetCertifiedOnline.Exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalCourseExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalCourseExceptionHandler.class);
	
	
	
		@ExceptionHandler(CourseNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorInfo handleCourseNotFoundException(CourseNotFoundException e, HttpServletRequest request) {
		
		logger.info("In controller advice to find the CourseId");
		
		ErrorInfo error = new ErrorInfo();    // create instance of ErrorInfo
		error.setUrl(request.getRequestURI());   
		error.setMessage(e.getMessage()); 
		
		return error;
	}
	
	
	


}
