package com.neoxamhr.webservice;

public class FormPost {
	
	private int id;
	private String dep;
	private String post;
	private String resp;
	private int estresp;
	
	
	public int getEstresp() {
		return estresp;
	}
	public void setEstresp(int estresp) {
		this.estresp = estresp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	
	public FormPost() {
		super();
	}
	
	public FormPost(String dep, String post, String resp) {
		super();
		this.dep = dep;
		this.post = post;
		this.resp = resp;
	}
	
	
	
	
	

}
