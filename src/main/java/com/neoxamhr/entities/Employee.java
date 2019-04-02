package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private int phone;
	private String responsable;
	private int estResp;
	
	@OneToMany(mappedBy="empl",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("empl")
	private List<Skills> skillsEmpl = new ArrayList<Skills>();
	
	@ManyToOne
	@JsonIgnoreProperties("team")
	private Team team;
	@OneToMany(mappedBy="empl")
	private List<Vacation> vac;
	
	
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
	
	public int getEstResp() {
		return estResp;
	}
	public void setEstResp(int isResp) {
		this.estResp = isResp;
	}
	
	public List<Skills> getSkillsEmpl() {
		return skillsEmpl;
	}
	
	public void setSkillsEmpl(List<Skills> skillsEmpl) {
		this.skillsEmpl = skillsEmpl;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
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
	
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public Employee(String firstname, String lastname, String email, String adress, String post, int phone, String resp) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.adress = adress;
		this.post = post;
		this.phone = phone;
		this.responsable= resp;
	}
	
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getIdEmpl() + " " + getFirstname() + " " + getLastname() + " " + getEmail()+ " "+ getPhone() +" "+ getResponsable() + " " + getTeam().getTeamName()+"xx "+this.estResp+" " ;
	}
	/*
	public void addSkills(Skills s) {
		SkillsEmpl se = new SkillsEmpl(s,this);
		this.lse.add(se);
		s.getLse().add(se);
	}
	*/
	
	
}
