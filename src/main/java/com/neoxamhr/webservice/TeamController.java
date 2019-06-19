package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.EmployeeRepository;
import com.neoxamhr.dao.TeamRepository;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Team;
import com.neoxamhr.webservice.model.TeamForm;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TeamController {

	@Autowired
	private TeamRepository tr;
	
	@Autowired
	private EmployeeRepository er;
	
	@RequestMapping(value="/allgroup")
	public Iterable<Team> allTeam(){
		return tr.findAll();
	}
	/*
	@RequestMapping(value="/addteam")
	public boolean addTeam(@RequestBody TeamForm tf) {
		Team t=new Team(tf.getTeamName());
		tr.save(t);
		return true;
	}
	*/
	
	@RequestMapping(value="/addteam")
	public boolean addTeam(@RequestParam String name) {
		try {
			tr.save(new Team(name));
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@RequestMapping(value="/addemptoteam")
	public boolean addEmpToTeam(@RequestBody TeamForm tf) {
		Team t=tr.findById(tf.getIdTeam()).get();
		
		String[] s=tf.getTeamName().split(" ");
		Employee e= er.findByFirstnameAndLastname(s[0], s[1]).get(0);
		System.out.println(e.getEmail());
		e.setTeam(t);
		er.save(e);
		
		return true;
	}
	
	
	
}
