package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.entities.Message;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MailAngularController {
	
	@Autowired
	public MailController ioc;
	
	@RequestMapping(value="/nosmail")
	public String nosMail(){
 		return "mail.html";
	}
}
