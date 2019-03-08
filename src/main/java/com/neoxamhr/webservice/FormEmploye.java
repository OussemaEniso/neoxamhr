package com.neoxamhr.webservice;

public class FormEmploye {
	
	private int id;
	private String lastname;
	private String firstname;
	private String adress;
	private String email;
	private Long phone;
	private String post;
	
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public FormEmploye(String lastname, String firstname, String adress, String email, Long phone, String post) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.email = email;
		this.phone = phone;
		this.post = post;
	}
	public FormEmploye() {
		super();
	}

}
