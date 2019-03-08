package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity
public class Employee{
	
	@Id
	@GeneratedValue
	private int idEmpl;
	
	private String firstname;
	private String lastname;
	private String email;
	private String adress;
	private String post;
	private long phone;
	/*
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<SkillsEmpl> lse;
	
	public List<SkillsEmpl> getLse() {
		return lse;
	}
	public void setLse(List<SkillsEmpl> lse) {
		this.lse = lse;
	}
	*/
	
	@OneToMany(mappedBy="empl",cascade=CascadeType.ALL)
	private List<Skills> skillsEmpl = new ArrayList<Skills>();
	
	@ManyToOne
	private Team team;
	@OneToMany(mappedBy="empl")
	private List<Vacation> vac;
	
	
	public List<Skills> getSkillsEmpl() {
		return skillsEmpl;
	}
	public void setSkillsEmpl(List<Skills> skillsEmpl) {
		this.skillsEmpl = skillsEmpl;
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public List<Vacation> getVac() {
		return vac;
	}
	public void setVac(List<Vacation> vac) {
		this.vac = vac;
	}
	public int getIdEmpl() {
		return idEmpl;
	}
	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Employee(String firstname, String lastname, String email, String adress, String post, long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adress = adress;
		this.post = post;
		this.phone = phone;
	}
	
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getIdEmpl() + " " + getFirstname() + " " + getLastname() + " " + getEmail()+ " ";
	}
	/*
	public void addSkills(Skills s) {
		SkillsEmpl se = new SkillsEmpl(s,this);
		this.lse.add(se);
		s.getLse().add(se);
	}
	*/
	
	
}
