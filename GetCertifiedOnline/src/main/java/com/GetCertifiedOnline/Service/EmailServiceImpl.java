package com.GetCertifiedOnline.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.GetCertifiedOnline.Entity.EmailNotification;

@Service
public class EmailServiceImpl {
@Autowired
private JavaMailSender javaMailSender;


public void sendEmail(EmailNotification emailNotification) {
SimpleMailMessage msg = new SimpleMailMessage();
try {
	if (emailNotification.getSendTo().contains(",")) {
		String[] emails = emailNotification.getSendTo().split(",");
		int receipantSize = emails.length;
			for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject(emailNotification.getSubject());
					msg.setText(emailNotification.getBody());
					javaMailSender.send(msg);
				}

			} else {
				msg.setTo(emailNotification.getSendTo());
				msg.setSubject(emailNotification.getSubject());
				msg.setText(emailNotification.getBody());
				javaMailSender.send(msg);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}