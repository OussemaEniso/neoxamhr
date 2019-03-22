package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {
	@Id
	@GeneratedValue
	private int idProj;
	private String name;
	@OneToMany(mappedBy="project")
	private List<Team> teams;
	@ManyToMany
	private List<SkillsProj> skillsProj;
	
	public int getIdProj() {
		return idProj;
	}
	public void setIdProj(int idProj) {
		this.idProj = idProj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	public List<SkillsProj> getSkillsProj() {
		return skillsProj;
	}
	public void setSkillsProj(List<SkillsProj> skillsProj) {
		this.skillsProj = skillsProj;
	}
	public Project(String name) {
		super();
		this.name = name;
	}
	public Project() {
		super();
	}
	
	
	
	

}
