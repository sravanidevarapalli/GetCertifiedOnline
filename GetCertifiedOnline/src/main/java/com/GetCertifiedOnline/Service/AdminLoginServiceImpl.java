package com.GetCertifiedOnline.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.GetCertifiedOnline.Entity.AdminLogin;
import com.GetCertifiedOnline.Repository.AdminLoginRepository;

@Component
@Service
public class AdminLoginServiceImpl implements AdminLoginService {
	
	@Autowired
	private AdminLoginRepository adminLoginRepository;
	Logger logger = LoggerFactory.getLogger(AdminLoginServiceImpl.class);
// saves the address using post mapping
	public <Optional> AdminLogin registerNewAdmin(AdminLogin admin) {
		return adminLoginRepository.save(admin);
	}

	
	

	
public AdminLogin save(AdminLogin c2) {
		// TODO Auto-generated method stub
		return null;
	}

public boolean adminLogin(String mailId,String userName,String password)
{
	Boolean found= false;
	if(mailId==null)
	{
		System.out.println("Please enter mail id");
	}
	List<AdminLogin> admins=(List<AdminLogin>)adminLoginRepository.findAll();
	for(AdminLogin admin : admins)
	{
		if((admin.getMailId().equals(mailId)) && (admin.getUserName().equals(userName)) && (admin.getPassword().equals(password)))
		{
			found=true;
			break;
		}
	}
	return found;
}



}
