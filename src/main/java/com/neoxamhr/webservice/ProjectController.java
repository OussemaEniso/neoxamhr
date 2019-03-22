package com.neoxamhr.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.entities.Project;
import com.neoxamhr.entities.Team;
import com.neoxamhr.services.ProjectRepository;
import com.neoxamhr.services.TeamRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {
	
	@Autowired
	private ProjectRepository pr;
	
	@Autowired
	private TeamRepository tr;
	
	@RequestMapping(value="/allproject")
	public Iterable<Project> allProject() {
		return pr.findAll();
	}
	
	@RequestMapping(value="/teamnotyet")
	public Iterable<Team> teamNotYet() {
		return  tr.findNotYet();
	}
	
	@RequestMapping(value="/addproj")
	public boolean addProject(@RequestBody ProjectForm pf) {
		pr.save(new Project(pf.getName()));
		return true;
	}
	
	@RequestMapping(value="/addteamproject")
	public boolean addTeamProject(@RequestBody ProjectForm pf) {
		
		Project p=pr.findById(pf.getId()).get();
		
		Team t= tr.findByTeamName(pf.getName()).get(0);
		
		t.setProject(p);
		
		tr.save(t);
		
		return true;
	}

}
