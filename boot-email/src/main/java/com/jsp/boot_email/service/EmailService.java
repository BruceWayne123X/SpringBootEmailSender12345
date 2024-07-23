package com.jsp.boot_email.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailDetails;
import com.jsp.boot_email.dto.EmailList;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
	@Autowired
    JavaMailSender mailSender;
	public void sendMessage(Email email) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email.getTo());
//		message.setFrom("dhruvjain01102001@gmail.com");
		message.setSubject(email.getSubject());
        message.setText(email.getBody());
        message.setFrom("dhruvjain01102001@gmail.com");
        mailSender.send(message);
	}
	
	
	
	public void sendMessageToRecep(EmailList email) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email.getTo());
//		message.setFrom("dhruvjain01102001@gmail.com");
		message.setSubject(email.getSubject());
        message.setText(email.getBody());
        message.setFrom("dhruvjain01102001@gmail.com");
        mailSender.send(message);
	}
	public void sendEmailWithAttachment(EmailDetails details) throws MessagingException, IOException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(details.getTo());
		helper.setSubject(details.getSubject());
		helper.setText(details.getBody());
		message.setFrom("dhruvjain01102001@gmail.com");

		FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));
		helper.addAttachment(file.getFilename(), file);

		mailSender.send(message);
		}

public void sendHtmlEmail() throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();

    message.setFrom(new InternetAddress("dhruvjain01102001@gmail.com"));
    message.setRecipients(MimeMessage.RecipientType.TO, "dhruvjain01102001@gmail.com");
    message.setSubject("Test email from Spring");

    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
                         "<p>It can contain <strong>HTML</strong> content.</p>";
    message.setContent(htmlContent, "text/html; charset=utf-8");

    mailSender.send(message);
}
}
