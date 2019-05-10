package com.neoxamhr.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class VacWithOutPay {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String type;
	private String periode;
	
	@ManyToMany(mappedBy="vacNoPay")
	private Set<Employee> emp; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	
	public Set<Employee> getEmp() {
		return emp;
	}
	public void setEmp(Set<Employee> emp) {
		this.emp = emp;
	}
	public VacWithOutPay() {
		super();
	}
	public VacWithOutPay(String type, String periode) {
		super();
		this.type = type;
		this.periode = periode;
	}
	
	
	
	
	
	
}
