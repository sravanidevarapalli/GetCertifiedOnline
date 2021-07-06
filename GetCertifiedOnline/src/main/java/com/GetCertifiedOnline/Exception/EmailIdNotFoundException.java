package com.GetCertifiedOnline.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailIdNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public EmailIdNotFoundException(String s) 
    { 
        super(s); 
    } 
}
