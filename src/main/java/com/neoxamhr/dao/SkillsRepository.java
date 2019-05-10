package com.neoxamhr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
	
	@Query("SELECT distinct s.skillsName FROM Skills s")
	List<Skills> findAllSkills();
	
	@Query("SELECT e FROM Employee e join Skills s on s.empl.idEmpl=e.idEmpl AND s.skillsName=?1")
	List<Employee> findEmployeBySkills(String skills);
	
	@Query("SELECT s FROM Skills s join Employee e on s.empl.idEmpl=?1 AND lower(s.skillsName)=lower(?2)")
	List<Skills> findSkills(int id,String skills);
	

}
