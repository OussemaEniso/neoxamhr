package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class SkillsProj implements Serializable{
	
	@Id
	@GeneratedValue
	private int idSkillsProj;
	private String name;
	private String level;
	@ManyToMany(mappedBy="skillsProj")
	private List<Project> project;
	

	public int getIdSkillsProj() {
		return idSkillsProj;
	}
	public void setIdSkillsProj(int idSkillsProj) {
		this.idSkillsProj = idSkillsProj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<Project> getProject() {
		return project;
	}
	public void setProject(List<Project> project) {
		this.project = project;
	}
	
	
}
