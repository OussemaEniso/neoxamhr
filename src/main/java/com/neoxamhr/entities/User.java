package com.neoxamhr.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String mail;
	private long phone;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String firstname, String lastname, String login, String password,long phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.phone=phone;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public User() {
		super();
	}
	
	
	
	
}
