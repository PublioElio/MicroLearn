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

	private List<Course> courses;

	@PostConstruct
	public void init() {
		courses = new ArrayList<>();
		courses.add(new Course("Spring Boot", 150, "Tarde"));
		courses.add(new Course("Python", 300, "Tarde"));
		courses.add(new Course("Java EE", 250, "Mañana"));
		courses.add(new Course("Java Script", 150, "Tarde"));
		courses.add(new Course("Linux", 80, "Finde"));
	}

	@GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course getCourse() {
		return new Course("Java", 100, "Morning");
	}

}
