package com.neoxamhr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Team;

public interface TeamRepository extends CrudRepository<Team, Integer>  {
	
	List<Team> findByTeamNameIgnoreCase(String name);
	
	@Query("select t from Team t where t.project is null")
	List<Team> findNotYet();

}
