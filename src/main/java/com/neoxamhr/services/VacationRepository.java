package com.neoxamhr.services;

import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Vacation;

public interface VacationRepository extends CrudRepository<Vacation, Integer> {
	
	@Query("select e from Employee e join Vacation v on v.empl.idEmpl = e.idEmpl")
	List<Employee> findEmpVac();
	
	@Modifying
	@Transactional
	@Query("delete from Vacation v where v.empl.idEmpl= ?1")
	void deleteVac(int id); 
	
	@Query("select v from Vacation v where v.start > ?1")
	List<Vacation> newVacc(Date d);

}
