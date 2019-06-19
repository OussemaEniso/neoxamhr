package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.NotificationRepository;
import com.neoxamhr.entities.Notification;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class NotificationController {
	
	@Autowired
	private NotificationRepository nr;
	
	@RequestMapping(value="/getnotif/{id}")
	public List<Notification> getNotif(@PathVariable int id){
		return nr.getNotif(id);
	}

}
