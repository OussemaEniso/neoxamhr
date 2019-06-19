package com.neoxamhr.webservice.model;

public class AuthUser {
	
	private String login;
	private String password;
	
	
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
	public AuthUser(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	@Override
	public String toString() {
		return "user { login = "+login+" password = "+password+" }";
	}
	
	

}