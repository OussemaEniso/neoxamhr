package com.neoxamhr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String crea;
	@Temporal(TemporalType.DATE)
	private Date start;
	@Temporal(TemporalType.DATE)
	private Date end;
	private String dedicated;
	private int estnotif;
	
	
	public int getEstnotif() {
		return estnotif;
	}
	public void setEstnotif(int estnotif) {
		this.estnotif = estnotif;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCrea() {
		return crea;
	}
	public void setCrea(String crea) {
		this.crea = crea;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getDedicated() {
		return dedicated;
	}
	public void setDedicated(String dedicated) {
		this.dedicated = dedicated;
	}
	
	public Event(String name, String crea, Date start, Date end, String dedicated) {
		super();
		this.name = name;
		this.crea = crea;
		this.start = start;
		this.end = end;
		this.dedicated = dedicated;
	}
	public Event() {
		super();
	}
	
	
	
	
}
