package com.neoxamhr.webservice;

import java.sql.Time;
import java.util.Date;

public class EventModel {
	
	
	private String name;
	private String crea;
	private Date start;
	private TimeModel timestart;
	private Date end;
	private TimeModel timeend;
	private String ded;
	private String room;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCrea() {
		return crea;
	}
	public void setCrea(String crea) {
		this.crea = crea;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getDed() {
		return ded;
	}
	public void setDed(String ded) {
		this.ded = ded;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public TimeModel getTimestart() {
		return timestart;
	}
	public void setTimestart(TimeModel timestart) {
		this.timestart = timestart;
	}
	public TimeModel getTimeend() {
		return timeend;
	}
	public void setTimeend(TimeModel timeend) {
		this.timeend = timeend;
	}
	public EventModel(String name, String crea, Date start, Date end, String ded,String room) {
		super();
		this.name = name;
		this.crea = crea;
		this.start = start;
		this.end = end;
		this.ded = ded;
		this.room=room;
	}
	
	public EventModel() {
		super();
	}
	
}

class TimeModel{
	private int hour;
	private int minute;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public TimeModel(int hour, int minute) {
		super();
		this.hour= hour;
		this.minute = minute;
	}
	
	public TimeModel() {
		super();
	}
	
	
	
	
}

