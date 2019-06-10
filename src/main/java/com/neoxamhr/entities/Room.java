package com.neoxamhr.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Room {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private int capacite;
	
	@OneToMany(mappedBy="room")
	@JsonIgnoreProperties("room")
	private List<Event> event;
	
	public List<Event> getEvent() {
		return event;
	}
	public void setEvent(List<Event> event) {
		this.event = event;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	public Room(String name, int capacite) {
		super();
		this.name = name;
		this.capacite = capacite;
	}
	
	public Room() {
		super();
	}
	
}
