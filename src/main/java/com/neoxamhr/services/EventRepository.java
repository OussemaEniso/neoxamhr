package com.neoxamhr.services;

import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
