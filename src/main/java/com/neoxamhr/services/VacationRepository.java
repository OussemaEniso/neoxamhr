package com.neoxamhr.services;

import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Vacation;

public interface VacationRepository extends CrudRepository<Vacation, Integer> {

}
