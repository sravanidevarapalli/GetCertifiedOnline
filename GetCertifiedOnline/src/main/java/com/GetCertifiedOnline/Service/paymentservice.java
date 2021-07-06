package com.GetCertifiedOnline.Service;

import java.util.List;

import com.GetCertifiedOnline.Entity.PaymentDetails;



public interface paymentservice {

	//This method is used to add payment Details 
	public PaymentDetails addPaymentDetails(PaymentDetails p); 
	
	//This method is used to get all payment details
		public List<PaymentDetails> getAllPaymentDetails();
		
		
}