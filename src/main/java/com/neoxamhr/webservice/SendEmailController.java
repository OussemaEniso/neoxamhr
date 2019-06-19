package com.neoxamhr.webservice;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.SendEmailRepository;
import com.neoxamhr.entities.SendEmail;
import com.neoxamhr.webservice.model.EmailForm;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SendEmailController {
	
	@Autowired
	private SendEmailRepository emailrep;
	
	 @Autowired
	    public JavaMailSender emailSender;
	 
	    public void sendSimpleMessage(String to, String subject, String text) {
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	    }

	@RequestMapping(value = "/sendemail")
	public @ResponseBody boolean sendmail(@RequestBody EmailForm e)  {
		if(e.getDest()!=null && e.getObject()!=null) {
		sendSimpleMessage(e.getDest(), e.getObject(), e.getMessage()); 
		emailrep.save(new SendEmail(e.getDest(), e.getObject(), e.getMessage(),new Date()));
		}
	   return true;   
	}
	
	@RequestMapping(value="allmsg")
	public Iterable<SendEmail> getAllMsg() {
		return emailrep.findAll();
	}
	
	
	
	
	
}
