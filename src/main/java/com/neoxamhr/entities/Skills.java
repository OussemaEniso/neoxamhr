package com.neoxamhr.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Skills {
	
	@Id
	@GeneratedValue
	private int idSkills;
	private String skillsName;
	private int level;
	/*
	@OneToMany(mappedBy="skills", cascade=CascadeType.ALL,orphanRemoval = true)
	private List<SkillsEmpl> lse;
	*/
	
	@ManyToOne
	@JsonIgnoreProperties("skillsEmpl")
	private Employee empl;
	
	/*
	public List<SkillsEmpl> getLse() {
		return lse;
	}
	public void setLse(List<SkillsEmpl> lse) {
		this.lse = lse;
	}
	*/
	public int getIdSkills() {
		return idSkills;
	}
	public void setIdSkills(int idSkills) {
		this.idSkills = idSkills;
	}
	public String getSkillsName() {
		return skillsName;
	}
	public void setSkillsName(String skillsName) {
		this.skillsName = skillsName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public Employee getEmpl() {
		return empl;
	}
	public void setEmpl(Employee empl) {
		this.empl = empl;
	}
	public Skills(String skillsName, int level, Employee empl) {
		super();
		this.skillsName = skillsName;
		this.level = level;
		this.empl = empl;
	}
	
	public Skills() {
		super();
	}
	public Skills(int level) {
		super();
		this.level = level;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
