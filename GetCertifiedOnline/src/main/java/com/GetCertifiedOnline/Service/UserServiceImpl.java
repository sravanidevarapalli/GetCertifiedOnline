package com.GetCertifiedOnline.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GetCertifiedOnline.Entity.User;
import com.GetCertifiedOnline.Repository.UserRepository;




@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userdao;

	@Override
	public List<User> loginUser(String username, String password) {

		List<User> user = userdao.loginUser(username, password);
		if(user!=null) {
			return user;
		}
		return null;
		
		
	}

	@Override
	public User UserRegistration(User user) {

		return userdao.save(user);
	}

	
}
