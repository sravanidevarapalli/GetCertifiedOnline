package com.GetCertifiedOnline.Service;

import java.util.List;

import com.GetCertifiedOnline.Entity.User;



/**
 * This is an interface for LoginService class, it has all the abstract
 * methods
 * 
 * @author sravani 
 *
 */
public interface UserService {

	
	 public List<User> loginUser(String username,String password);	
	    
	    public User UserRegistration(User user);
}