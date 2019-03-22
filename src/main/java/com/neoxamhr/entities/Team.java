package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Team implements Serializable{
	
	@Id
	@GeneratedValue
	private int idTeam;
	private String teamName;
	@OneToMany(mappedBy="team")
	private List<Employee> team;
	@ManyToOne
	@JsonIgnoreProperties("teams")
	private Project project;
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public List<Employee> getTeam() {
		return team;
	}
	public void setTeam(List<Employee> team) {
		this.team = team;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	public Team() {
		super();
	}
	
	public Team(String teamName) {
		super();
		this.teamName = teamName;
	}
	
	public Team(String teamName, List<Employee> team) {
		super();
		this.teamName = teamName;
		this.team = team;
	}
	public Team(String teamName, List<Employee> team, Project project) {
		super();
		this.teamName = teamName;
		this.team = team;
		this.project = project;
	}
	
	
	
	
}
