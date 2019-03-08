package com.neoxamhr.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Vacation implements Serializable{

	@Id
	@GeneratedValue
	private int idVac;
	private String VacationName;
	@Temporal(TemporalType.DATE)
	private Date start;
	@Temporal(TemporalType.DATE)
	private Date end;
	@ManyToOne
	@JsonIgnoreProperties("vac")
	private Employee empl;
	
	public int getIdVac() {
		return idVac;
	}
	public void setIdVac(int idVac) {
		this.idVac = idVac;
	}
	public String getVacationName() {
		return VacationName;
	}
	public void setVacationName(String vacationName) {
		VacationName = vacationName;
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
	public Employee getEmpl() {
		return empl;
	}
	public void setEmpl(Employee empl) {
		this.empl = empl;
	}
	public Vacation(String vacationName, Date start, Date end, Employee empl) {
		super();
		VacationName = vacationName;
		this.start = start;
		this.end = end;
		this.empl = empl;
	}
	public Vacation() {
		super();
	}
	
	
	
	
}
