package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.SkillsRepository;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Skills;
import com.neoxamhr.webservice.model.SkillsForm;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SkillsController {

	@Autowired
	private SkillsRepository sr;
	
	@RequestMapping(value="/allskills")
	public List<Skills> getAllSkills() {
		return sr.findAllSkills();
	}
	
	@RequestMapping(value="/find")
	public List<Employee> findByList(@RequestBody SkillsForm sf ){
		return sr.findEmployeBySkills(sf.getNameSkil());
	}
	
	
	
	
}
