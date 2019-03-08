package com.neoxamhr.webservice;

public class SkillsForm {
	
	private int idEmp;
	private String nameSkil;
	private int level;
	
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	public String getNameSkil() {
		return nameSkil;
	}
	public void setNameSkil(String nameSkil) {
		this.nameSkil = nameSkil;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	public SkillsForm(int idEmp, String nameSkil, int level) {
		super();
		this.idEmp = idEmp;
		this.nameSkil = nameSkil;
		this.level = level;
	}
	public SkillsForm(String nameSkil, int level) {
		super();
		this.nameSkil = nameSkil;
		this.level = level;
	}
	
	public SkillsForm() {
		super();
	}
	
	
	
	

}
