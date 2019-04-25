package com.neoxamhr.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.entities.Holidays;
import com.neoxamhr.services.HolidaysRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HolidaysController {
	
	@Autowired
	private HolidaysRepository hr;
	
	@RequestMapping(value="/addholi")
	public boolean addHoli(@RequestParam String date,@RequestParam String desc) {
		hr.save(new Holidays( date,desc));
		return true;
	}
	
	@RequestMapping(value="/allholi")
	public List<Holidays> allHoli(){
		return (List<Holidays>) hr.findAll();
	}
	
	@RequestMapping(value="/modholi")
	public boolean modHoli(@RequestParam int id,@RequestParam String date, @RequestParam String desc) {
		Holidays h= hr.findById(id).get();
		h.setDateHoli(date);
		h.setDescription(desc);
		
		try {
			hr.save(h);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
		
	}
}
