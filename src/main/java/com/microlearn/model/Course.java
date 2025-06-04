package com.microlearn.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Represents a course in the MicroLearn system. This class holds information
 * about the course title, length, and schedule. It is annotated with
 * {@code @JacksonXmlRootElement} to support XML serialization.
 */
@JacksonXmlRootElement
public class Course {

	/** The title of the course. */
	private String title;

	/** The duration of the course in hours. */
	private int length;

	/** The schedule of the course (e.g., afternoon, weekends). */
	private String schedule;

	/**
	 * Constructs a new Course with the specified title, length, and schedule.
	 * 
	 * @param title    The title of the course.
	 * @param length   The duration of the course.
	 * @param schedule The schedule of the course.
	 */
	public Course(String title, int length, String schedule) {
		this.title = title;
		this.length = length;
		this.schedule = schedule;
	}

	/**
	 * Default constructor for creating an empty Course instance.
	 */
	public Course() {
	}

	/**
	 * Retrieves the title of the course.
	 * 
	 * @return The course title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the course.
	 * 
	 * @param title The new course title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Retrieves the length of the course.
	 * 
	 * @return The course duration.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the length of the course.
	 * 
	 * @param length The new course duration.
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Retrieves the schedule of the course.
	 * 
	 * @return The course schedule.
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * Sets the schedule of the course.
	 * 
	 * @param schedule The new course schedule.
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

}
