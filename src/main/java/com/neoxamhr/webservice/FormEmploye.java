package com.neoxamhr.webservice;

import java.util.Date;

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
	private String sexe;
    private int cin;
    private int cnss;
    private Date naiss;
    private String ville;
    private String mat;
    private Date dateent;
    private int salaire;
	
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEstResp() {
		return estResp;
	}
	public void setEstResp(int isResp) {
		this.estResp = isResp;
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
	
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public int getCnss() {
		return cnss;
	}
	public void setCnss(int cnss) {
		this.cnss = cnss;
	}
	public Date getNaiss() {
		return naiss;
	}
	public void setNaiss(Date naiss) {
		this.naiss = naiss;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public Date getDateent() {
		return dateent;
	}
	public void setDateent(Date dateent) {
		this.dateent = dateent;
	}
	public int getSalaire() {
		return salaire;
	}
	public void setSalaire(int salaire) {
		this.salaire = salaire;
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
	
	public FormEmploye(String lastname, String firstname, String adress, String email, int ph, String post, String dep,
			String responsable, int estResp, String sexe, int cin, int cnss, Date naiss, String ville, String mat,
			Date dateent, int salaire) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.adress = adress;
		this.email = email;
		this.ph = ph;
		this.post = post;
		this.dep = dep;
		this.responsable = responsable;
		this.estResp = estResp;
		this.sexe = sexe;
		this.cin = cin;
		this.cnss = cnss;
		this.naiss = naiss;
		this.ville = ville;
		this.mat = mat;
		this.dateent = dateent;
		this.salaire = salaire;
	}
	
	public FormEmploye() {
		super();
	}
	@Override
	public String toString() {
		return this.adress + " " + this.email + " " + this.firstname + " " + this.lastname + " " + this.ph  ;
		
	}
	
	

}
