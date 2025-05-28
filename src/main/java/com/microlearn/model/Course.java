package com.microlearn.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Course {
	private String title;
	private int length;
	private String schedule;

	public Course(String title, int length, String schedule) {
		this.title = title;
		this.length = length;
		this.schedule = schedule;
	}
	
	public Course() {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
