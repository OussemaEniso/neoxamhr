package com.neoxamhr.services;

import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Holidays;

public interface HolidaysRepository extends CrudRepository<Holidays, Integer> {

}
