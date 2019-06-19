package com.neoxamhr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	@Query("select e from Event e join Employee emp on emp.team.teamName=e.dedicated ")
	public List<Event> eventOfEmpl(String post);
	
	@Query("select e from Event e join Room r on e.room.id=r.id and r.name=?1")
	public List<Event> eventOfRoom(String name);

}
