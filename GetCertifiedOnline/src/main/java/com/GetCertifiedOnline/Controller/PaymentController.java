package com.GetCertifiedOnline.Controller;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GetCertifiedOnline.Entity.PaymentDetails;
import com.GetCertifiedOnline.Service.paymentservice;

import io.swagger.annotations.Api;
@Api
@CrossOrigin("*")
@RestController()
@RequestMapping("/paymentdetails")
@Validated
public class PaymentController {
	private static final Logger Logger = LoggerFactory.getLogger(PaymentController.class);
	@Autowired
	private paymentservice paymentService;
	

	@PostMapping("/addpaymentdetails")
	public PaymentDetails addPaymentDetails(@RequestBody PaymentDetails p) {
		Logger.info("Payment successful");
		return paymentService.addPaymentDetails(p);
		
	}
	 
	
	@GetMapping(value="/getallpaymentdetails")
	public List<PaymentDetails> getAllPaymentDetails() {
		Logger.info("get all paymentdetails");
		return paymentService.getAllPaymentDetails();
	}
	
	
}
	
	


