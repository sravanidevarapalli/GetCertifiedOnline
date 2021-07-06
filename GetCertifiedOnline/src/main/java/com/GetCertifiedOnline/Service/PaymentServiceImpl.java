package com.GetCertifiedOnline.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GetCertifiedOnline.Entity.PaymentDetails;
import com.GetCertifiedOnline.Repository.PaymentDAO;





@Service

public class PaymentServiceImpl implements paymentservice {

	@Autowired
	private PaymentDAO paymentdetails;

	@Override
	public PaymentDetails addPaymentDetails(PaymentDetails p) {
		paymentdetails.saveAndFlush(p);
		return p;
	}

	@Override
	public List<PaymentDetails> getAllPaymentDetails() {
		return paymentdetails.findAll();
	}


}