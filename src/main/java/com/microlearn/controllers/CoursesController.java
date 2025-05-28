package com.microlearn.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microlearn.model.Course;

@RestController
public class CoursesController {

	@GetMapping(value = "course", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course getCourse() {
		return new Course("Java", 100, "Morning");
	}

}
