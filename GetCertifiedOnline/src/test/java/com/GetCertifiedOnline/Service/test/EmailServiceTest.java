package com.GetCertifiedOnline.Service.test;






import org.junit.jupiter.api.Test;

import com.GetCertifiedOnline.Entity.EmailNotification;

public class EmailServiceTest {
	@Test
	void testSendTextEmail() {
		EmailNotification email = new EmailNotification("sudheergotteti07@gmail.com","Reminder","Hello Sudheer, you have exam");
		email.setSendTo("sudheergotteti07@gmail.com");
		email.setSubject("Reminder");
		email.setBody("Hello Sudheer,you have exam");
		
		//Mockito.when(certificationDao.save(certification)).thenReturn(certification);
       
	}

	
}