package com.neoxamhr.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Notification {

	@Id
	@GeneratedValue
	public int idNoti;
	public String description;
	@ManyToOne
	@JoinColumn
	public Employee empl;
	@Temporal(TemporalType.TIMESTAMP)
	public Date date;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getEmpl() {
		return empl;
	}
	public void setEmpl(Employee empl) {
		this.empl = empl;
	}
	public Notification(String description, Employee empl,Date date) {
		super();
		this.description = description;
		this.empl = empl;
		this.date=date;
	}
	
	public Notification() {
		super();
	}
	
	
	
	
	
	
	
}
