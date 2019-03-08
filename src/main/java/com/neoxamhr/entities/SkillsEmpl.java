package com.neoxamhr.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class SkillsEmpl {
	
	@EmbeddedId
	private SkillsEmplId skilEmpId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("SkillsId")
	private Skills skills;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("EmployeId")
	private Employee employee;

	public SkillsEmplId getSkilEmpId() {
		return skilEmpId;
	}

	public void setSkilEmpId(SkillsEmplId skilEmpId) {
		this.skilEmpId = skilEmpId;
	}

	

	public SkillsEmpl(Skills skills, Employee employee) {
		super();
		this.skills = skills;
		this.employee = employee;
		this.skilEmpId = new SkillsEmplId(employee.getIdEmpl(),skills.getIdSkills());
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SkillsEmpl() {
		super();
	}
	
	
	
	

}
