package com.neoxamhr.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
	
	List<Skills> findBySkillsName(String skillsName);
	
	@Query("SELECT distinct s.skillsName FROM Skills s")
	List<Skills> findAllSkills();
	
	@Query("SELECT e FROM Employee e join Skills s on s.empl.idEmpl=e.idEmpl AND s.skillsName=?1")
	List<Employee> findEmployeBySkills(String skills);
	

}
