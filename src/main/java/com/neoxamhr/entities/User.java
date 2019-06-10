package com.neoxamhr.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User{
	
	@Id
	@GeneratedValue
	private int id;

	private String password;
	private String mail;
	
	@OneToOne(mappedBy="user")
	@JsonIgnoreProperties("user")
	private Employee employee;
	
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
	
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	
	public User() {
		super();
	}
	@Override
	public String toString() {
		return this.id + " " +this.mail + " " ;
	}
	
	
	
	
	
}
