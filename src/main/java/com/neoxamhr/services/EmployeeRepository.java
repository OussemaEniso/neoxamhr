package com.neoxamhr.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	Employee findByEmail(String email);
	List<Employee> findByFirstnameAndLastname(String firstname,String lastname);
	List<Employee> findByPost(String post);
	
	@Query("select e from Employee e where e.team is null")
	List<Employee> findNotYet();
	

	

}
