package com.neoxamhr.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SkillsEmplId implements Serializable {
	
	private int EmployeId;
	
	private int SkillsId;
	
	public int getEmployeId() {
		return EmployeId;
	}
	public void setEmployeId(int employeId) {
		EmployeId = employeId;
	}
	public int getSkillsId() {
		return SkillsId;
	}
	public void setSkillsId(int skillsId) {
		SkillsId = skillsId;
	}
	public SkillsEmplId() {
		super();
	}
	public SkillsEmplId(int employeId, int skillsId) {
		super();
		EmployeId = employeId;
		SkillsId = skillsId;
	}
	
	
	
	
	
	
}
