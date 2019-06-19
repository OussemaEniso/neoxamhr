package com.neoxamhr.webservice.model;

import java.util.Date;

import com.neoxamhr.entities.Employee;

public class VacReceive {
	
	private int idVac;
	private String title;
	private Date start;
	private TimeModel timestart;
	private Date end;
	private TimeModel timeend;
	private String employe;
	private int nbrDay;
	
	public TimeModel getTimestart() {
		return timestart;
	}
	public void setTimestart(TimeModel timestart) {
		this.timestart = timestart;
	}
	public TimeModel getTimeend() {
		return timeend;
	}
	public void setTimeend(TimeModel timeend) {
		this.timeend = timeend;
	}
	public int getNbrDay() {
		return nbrDay;
	}
	public void setNbrDay(int nbrDay) {
		this.nbrDay = nbrDay;
	}
	public int getIdVac() {
		return idVac;
	}
	public void setIdVac(int idVac) {
		this.idVac = idVac;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getEmploye() {
		return employe;
	}
	public void setEmploye(String emp) {
		this.employe = emp;
	}
	public VacReceive() {
		super();
	}
	
	

}
