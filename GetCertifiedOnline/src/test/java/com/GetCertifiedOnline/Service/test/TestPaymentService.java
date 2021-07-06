package com.GetCertifiedOnline.Service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.GetCertifiedOnline.Entity.PaymentDetails;
import com.GetCertifiedOnline.Repository.PaymentDAO;
import com.GetCertifiedOnline.Service.PaymentServiceImpl;



@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)

public class TestPaymentService {
	@InjectMocks
	PaymentServiceImpl service;

	@Mock
	PaymentDAO dao;
	
	
	@Test
	public void addPaymentDetailsTest() {

		PaymentDetails user = new PaymentDetails(101,1, 500, "483748781287394", "Sushma", "04/23", "online");

		when(dao.saveAndFlush(user)).thenReturn(user);

		assertEquals(user, service.addPaymentDetails(user));
	}

	@Test
	public void getAllPaymentDetailsTest() {

		List<PaymentDetails> list = new ArrayList<>();
		PaymentDetails user1 = new PaymentDetails(120,1, 5000, "996078921237730", "Sravani", "04/23", "online");
		PaymentDetails user2 = new PaymentDetails(130,1, 6000, "792374878143098", "Dharani", "04/23", "online");
		list.add(user2);
		list.add(user1);

		when(dao.findAll()).thenReturn(list);
		List<PaymentDetails> loanschemeList = service.getAllPaymentDetails();
		assertEquals(2, loanschemeList.size());
		verify(dao, times(1)).findAll();

	}
	
	/* @Test public void getPaymentDetailsByIdTest() throws PaymentNotFoundException
	 { PaymentDetails user1 = new PaymentDetails(120, 5000, "996078921237730",
	  "Sravani", LocalDate.now(), "online"); PaymentDetails user2 = new
	  PaymentDetails(130, 6000, "792374878143098", "Dharani", LocalDate.now(),
	  "online"); dao.saveAndFlush(user1); dao.saveAndFlush(user2);
	  
	  when(dao.findById(user1.getPayment_Id())).thenReturn(Optional.of(user1));
	  
	  assertEquals(user1, service.getPaymentDetailsById(user2.getPayment_Id())); }
	 
*/
	@Test
	public void testdeletePaymentDetailsById() {
		PaymentDetails user = new PaymentDetails(120,1, 5000, "996078921237730", "Sravani", "04/23", "online");

		when(dao.existsById(user.getPayment_Id())).thenReturn(false);
		assertFalse(dao.existsById(user.getPayment_Id()));
	}

}


