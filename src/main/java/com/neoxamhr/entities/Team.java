package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Team implements Serializable{
	
	@Id
	@GeneratedValue
	private int idTeam;
	private String name;
	@OneToMany(mappedBy="team")
	private List<Employee> team;
	@ManyToOne
	private Project project;
	
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
