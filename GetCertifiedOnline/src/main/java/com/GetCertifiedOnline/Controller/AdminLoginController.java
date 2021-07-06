package com.GetCertifiedOnline.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.GetCertifiedOnline.Entity.AdminLogin;
import com.GetCertifiedOnline.Exception.AdminNotFoundException;
import com.GetCertifiedOnline.Exception.InputException;
import com.GetCertifiedOnline.Repository.AdminLoginRepository;
import com.GetCertifiedOnline.Service.AdminLoginServiceImpl;

@CrossOrigin("*")
@RestController
@Validated
@RequestMapping(value = "/AdminLogin")

public class AdminLoginController {
	@Autowired
	private AdminLoginServiceImpl adminLoginService;
	@Autowired
	private AdminLoginRepository adminLoginRepository;
	Logger logger = LoggerFactory.getLogger(AdminLoginController.class);
	@Autowired
	private com.GetCertifiedOnline.Service.MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/add_Admin")
	public ResponseEntity<AdminLogin> createNewAdmin(@Valid @RequestBody AdminLogin adminLogin, BindingResult result) {

		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return (ResponseEntity<AdminLogin>) errorMap;
		AdminLogin adminLogin1 = adminLoginRepository.save(adminLogin);
		return new ResponseEntity<>(adminLogin1, HttpStatus.CREATED);
	}
	public AdminLogin createNewAdmin(@RequestBody AdminLogin adminLogin) throws InputException {
		
		logger.info("AdminLogin registerNewAdmin()");
		
		return adminLoginService.registerNewAdmin(adminLogin);
	}

	
	//login 
	@PostMapping(value="/Admin_Login/login")
	public ResponseEntity<String> adminLogin(@RequestBody AdminLogin admin)
	{
		if(adminLoginService.adminLogin(admin.getMailId(),admin.getUserName(), admin.getPassword()))
		{
			return new ResponseEntity<String>("Login Successful)",HttpStatus.OK);
		}
		else
		{
			throw new AdminNotFoundException("Invalid Email Id or Password,please check your details and try again");
		}

	}
		

}
	



	




