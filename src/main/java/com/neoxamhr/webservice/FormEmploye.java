package com.neoxamhr.webservice;

public class FormEmploye {
	
	private int id;
	private String lastname;
	private String firstname;
	private String adress;
	private String email;
	private int ph;
	private String post;
	private String dep;
	private String responsable;
	private int estResp;
	
	public int getEstResp() {
		return estResp;
	}
	public void setEstResp(int isResp) {
		this.estResp = isResp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String resp) {
		this.responsable = resp;
	}
	
	public FormEmploye(String lastname, String firstname, String adress, String email, int ph, String post, String dep,String resp) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.email = email;
		this.ph = ph;
		this.post = post;
		this.dep= dep;
		this.responsable = resp;
	}
	public FormEmploye() {
		super();
	}
	@Override
	public String toString() {
		return this.id+" "+this.adress + " " + this.email + " " + this.firstname + " " + this.lastname + " " + this.ph  ;
		
	}
	
	

}
