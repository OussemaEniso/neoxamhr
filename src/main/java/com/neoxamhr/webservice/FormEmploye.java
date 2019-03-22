package com.neoxamhr.webservice;

public class FormEmploye {
	
	private int id;
	private String lastname;
	private String firstname;
	private String adress;
	private String email;
	private int phone;
	private String post;
	private String dep;
	private String resp;
	
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
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int ph) {
		this.phone = ph;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	
	public FormEmploye(String lastname, String firstname, String adress, String email, int phone, String post, String dep,String resp) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.post = post;
		this.dep= dep;
		this.resp = resp;
	}
	public FormEmploye() {
		super();
	}

}
