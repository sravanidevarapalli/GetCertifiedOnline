package com.GetCertifiedOnline.Controller.test;


import org.junit.jupiter.api.Test;

import com.GetCertifiedOnline.Entity.EmailNotification;

public class EmailControllerTest {
	
		@Test
	    void testSendTextEmail() throws Exception{
	        String URI = "/EmailNotification/SendEmail";
	        EmailNotification email = new EmailNotification("sudheergotteti07@gmail.com", "Reminder","Hello Sudheer you have exam");
	       
	        String jsonInput = this.converttoJson(email);
	       
	       
	    }

		private String converttoJson(EmailNotification email) {
			// TODO Auto-generated method stub
			return null;
		}

	}
