package com.neoxamhr.webservice.model;

public class EmailForm {
	
	private int idMail;
	private String dest;
	private String object;
	private String message;
	
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
	public EmailForm() {
		super();
	}
	public EmailForm(String dest, String object, String message) {
		super();
		this.dest = dest;
		this.object = object;
		this.message = message;
	}
	
	

}
