package com.neoxamhr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Holidays {

	@Id
	@GeneratedValue
	private int idHoli;
	private String dateHoli; 
	private String description;
	
	public int getIdHoli() {
		return idHoli;
	}
	public void setIdHoli(int idHoli) {
		this.idHoli = idHoli;
	}
	public String getDateHoli() {
		return dateHoli;
	}
	public void setDateHoli(String dateHoli) {
		this.dateHoli = dateHoli;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Holidays(String dateHoli, String description) {
		super();
		this.dateHoli = dateHoli;
		this.description = description;
	}
	public Holidays() {
		super();
	}
	
	
	
	
	
}
