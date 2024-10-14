package com.insurance.utils;

import java.io.File;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(String subject, String body, String to , File f) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		
		helper.setSubject(subject);
		helper.setText(body, true);
		helper.setTo(to);
		helper.addAttachment("Plans-Info", f);
		mailSender.send(mimeMessage);
		
		return true;
	}
}
