package com.neoxamhr.webservice.model;

public class RoomModel {
	
	private String name;
	private int capacity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public RoomModel(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
	
	public RoomModel() {
		super();
	}
	
	
	
	

}
