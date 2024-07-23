package com.jsp.boot_email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailDetails;
import com.jsp.boot_email.dto.EmailList;
import com.jsp.boot_email.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	EmailService service;
	@GetMapping("/message")
   public String msg() {
	return "hii";
   }
	@PostMapping("/send")
	public String sendMessage(@RequestBody Email email) {
//		System.out.println(email);
    try {
		service.sendMessage(email);
		return "message send Successfuly";	

	} catch (Exception e) {
         return "internal issue try again";
	}
	}
	
	
	
	@PostMapping("/sendAll")
	public String sendMessage(@RequestBody EmailList email) {
//		System.out.println(email);
    try {
		service.sendMessageToRecep(email);
		return "message send Successfuly";	

	} catch (Exception e) {
         return "internal issue try again";
	}
	}
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDetails details) {
		try {
			service.sendEmailWithAttachment(details);
			return "Mail with Attachment sent successfuly";
		} catch (Exception e) {
			return "Technical Problem";
		}
	
		
	}
	@PostMapping("/sendHtmlMail")
	public String sendHtmlMail() {
	   try {
		service.sendHtmlEmail();
		return "email sent successfully";
	} catch (Exception e) {
		return "Technical Failure";
	}
		
	}
	
}
