package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.entities.Event;
import com.neoxamhr.services.EventRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EventController {
	
	@Autowired
	private EventRepository er;
	
	@RequestMapping(value="/addevent")
	public boolean addEvent(@RequestBody EventModel event) {
		Event e = new Event(event.getName(),event.getCrea(),event.getStart(),event.getEnd(),event.getDed());
		try {
			er.save(e);
			return true;
		}
		catch(Exception ex) {
			return false;
		}	
	}
	
	@RequestMapping(value="/allevent")
	public List<Event> allEvent(){
		return (List<Event>) er.findAll();
	}
	
	@RequestMapping(value="/deleteevent")
	public boolean deleteEvent(@RequestParam int id) {
		try {
			er.deleteById(id);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	/*
	@RequestMapping(value="/eventofemp")
	public List<Event> eventOfEmpl(@RequestParam String post){
		return er.eventOfEmpl(post);
	}
	*/
	

}
