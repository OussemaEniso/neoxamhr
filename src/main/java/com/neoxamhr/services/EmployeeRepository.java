package com.neoxamhr.services;

import java.util.Date;
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
	
	@Query("select e from Employee e join User u on u.mail=?1 and e.email=?1")
	Employee findProfil(String mail);
	
	@Query("select distinct e from Employee e join Vacation v on e.responsable=?1 and v.empl.idEmpl=e.idEmpl and v.estcomf=0 ")
	List<Employee> findByResp(String name);
	
	@Query("select e from Employee e where e.estResp=1")
	List<Employee> allResponsable();
	
	@Query("select e from Employee e where e.responsable=?1")
	List<Employee> EmplOfResp(String name);

	

}
