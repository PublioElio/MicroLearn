package com.microlearn.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microlearn.model.Course;

import jakarta.annotation.PostConstruct;

@RestController
public class CoursesController {

	private final String PM_SCHEDULE = "Afternoon";
	private List<Course> courses;

	@PostConstruct
	public void init() {
		courses = new ArrayList<>();
		courses.add(new Course("Spring Boot", 150, PM_SCHEDULE));
		courses.add(new Course("Python", 300, PM_SCHEDULE));
		courses.add(new Course("Java EE", 250, "Morning"));
		courses.add(new Course("Java Script", 150, PM_SCHEDULE));
		courses.add(new Course("Linux", 80, "Weekends"));
	}

	@GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course getCourse() {
		return new Course("Java", 100, "Morning");
	}

}
