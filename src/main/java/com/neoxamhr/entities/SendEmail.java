package com.neoxamhr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SendEmail {
	@Id
	@GeneratedValue
	private int idMail;
	private String dest;
	private String object;
	private String message;
	@Temporal(TemporalType.DATE)
	private Date sendDate;
	
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public int getIdMail() {
		return idMail;
	}
	public void setIdMail(int idMail) {
		this.idMail = idMail;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public SendEmail(String dest, String object, String message, Date sendDate) {
		super();
		this.dest = dest;
		this.object = object;
		this.message = message;
		this.sendDate = sendDate;
	}
	public SendEmail() {
		super();
	}
	
	

}
