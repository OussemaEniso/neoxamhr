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
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	@ManyToOne
	@JsonIgnoreProperties("vac")
	private Employee empl;
	private int estcomf;
	private double nbrDay;
	private int estnotif;
	
	
	public int getEstnotif() {
		return estnotif;
	}
	public void setEstnotif(int estnotif) {
		this.estnotif = estnotif;
	}
	public double getNbrDay() {
		return nbrDay;
	}
	public void setNbrDay(double nbrDay) {
		this.nbrDay = nbrDay;
	}
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
	public int getEstcomf() {
		return estcomf;
	}
	public void setEstcomf(int estcomf) {
		this.estcomf = estcomf;
	}
	public Vacation(String vacationName, Date start, Date end, Employee empl,double nbrDay) {
		super();
		VacationName = vacationName;
		this.start = start;
		this.end = end;
		this.empl = empl;
		this.nbrDay=nbrDay;
	}
	public Vacation() {
		super();
	}
	
	
	
	
}
