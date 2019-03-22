package com.neoxamhr.webservice;

import java.util.List;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Project;

public class TeamForm {
	
	private int idTeam;
	private String teamName;
	
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public TeamForm(String teamName) {
		super();
		this.teamName = teamName;
	}
	public TeamForm() {
		super();
	}
	
	
	
	
}
