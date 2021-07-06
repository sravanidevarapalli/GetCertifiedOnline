package com.GetCertifiedOnline.Exception;

public class InputException extends RuntimeException{
public InputException(String message) {
	super(message);
	//Wrong input,null value,validations wrongly passed for post method
}
}
