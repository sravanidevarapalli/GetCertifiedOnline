package com.GetCertifiedOnline.Service;

import java.util.List;
import com.GetCertifiedOnline.Entity.AdminLogin;

public interface AdminLoginService {
	
	static <Optional>AdminLogin registerNewAdmin(AdminLogin adminLogin) {
		// TODO Auto-generated method stub
		return adminLogin;
	}

	public boolean adminLogin(String mailId,String userName,String password);

	
	}

	


