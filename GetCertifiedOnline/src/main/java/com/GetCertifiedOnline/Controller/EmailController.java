package com.GetCertifiedOnline.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GetCertifiedOnline.Entity.EmailNotification;
import com.GetCertifiedOnline.Service.EmailService;
import com.GetCertifiedOnline.Service.EmailServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/EmailNotification")

public class EmailController {
@Autowired
private EmailServiceImpl emailService;

@PostMapping(value="/SendEmail")
public String sendEmail(@RequestBody EmailNotification emailNotification) {
try {
		//log.info("Sending  Email Notification....");
		emailService.sendEmail(emailNotification);
		return "Email Sent successfully :)";
		} catch (Exception ex) {
		return "Error in sending email :( " + ex;
		}
	}

		

	}
