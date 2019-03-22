package com.neoxamhr.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	
}
