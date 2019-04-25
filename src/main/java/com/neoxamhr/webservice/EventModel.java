package com.neoxamhr.webservice;

import java.util.Date;

public class EventModel {
	
	
	private String name;
	private String crea;
	private Date start;
	private Date end;
	private String ded;
	
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
	public String getDed() {
		return ded;
	}
	public void setDed(String ded) {
		this.ded = ded;
	}
	
	public EventModel(String name, String crea, Date start, Date end, String ded) {
		super();
		this.name = name;
		this.crea = crea;
		this.start = start;
		this.end = end;
		this.ded = ded;
	}
	
	public EventModel() {
		super();
	}
	
	
	
	
	
}
