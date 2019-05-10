package com.neoxamhr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
	
	@Query("select e from Event e join Employee emp on emp.team.teamName=e.dedicated ")
	public List<Event> eventOfEmpl(String post);

}
