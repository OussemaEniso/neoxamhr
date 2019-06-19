package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.RoomRepository;
import com.neoxamhr.entities.Room;
import com.neoxamhr.webservice.model.RoomModel;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RoomController {
	
	@Autowired
	private RoomRepository rr;
	
	@RequestMapping(value="/allroom")
	public Iterable<Room> allRoom(){
		return rr.findAll();
	}
	
	@RequestMapping(value="/addroom")
	public boolean addRoom(@RequestBody RoomModel room) {
		try {
			rr.save(new Room(room.getName(),room.getCapacity()));
			return true;
		}
		catch(Exception exc) {
			return false;
		}
		
	}

}
