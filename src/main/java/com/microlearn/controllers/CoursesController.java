package com.microlearn.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microlearn.model.Course;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	private static final String PM_SCHEDULE = "Afternoon";
	private List<Course> courses;

	@PostConstruct
	public void init() {
		courses = new ArrayList<>();
		courses.add(new Course("Spring Boot", 150, PM_SCHEDULE));
		courses.add(new Course("Python", 300, PM_SCHEDULE));
		courses.add(new Course("Java EE", 250, "Morning"));
		courses.add(new Course("JavaScript", 150, PM_SCHEDULE));
		courses.add(new Course("Linux", 80, "Weekends"));
	}

	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Course> getCourses() {
		return courses;
	}

	@GetMapping(value = "/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> searchCourses(@PathVariable String title) {
		return courses.stream().filter(c -> c.getTitle().contains(title)).toList();
	}

	@GetMapping(value = "/course", produces = MediaType.APPLICATION_XML_VALUE)
	public Course getCourse() {
		return new Course("Java", 100, "Morning");
	}

	@DeleteMapping(value = "/{title}")
	public ResponseEntity<String> deleteCourse(@PathVariable String title) {
		boolean removed = courses.removeIf(c -> c.getTitle().equalsIgnoreCase(title));

		if (removed) {
			return ResponseEntity.ok("Course '" + title + "' deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course '" + title + "' not found.");
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> addCourse(@RequestBody Course course) {
	    courses.add(course);
	    Map<String, String> response = Map.of("message", "Course added successfully!");
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}


}
