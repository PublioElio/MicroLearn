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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microlearn.model.Course;

import jakarta.annotation.PostConstruct;

/**
 * Controller for managing courses in the system.
 * 
 * This REST controller provides endpoints for retrieving, adding, updating, 
 * and deleting courses. It uses an in-memory list to simulate course data.
 * 
 * @author Adriano Díaz Benítez
 */
@RestController
@RequestMapping("/courses")
public class CoursesController {

	private static final String PM_SCHEDULE = "Afternoon";
	
	private static final String MORNING_SCHEDULE = "Morning";
	
	private static final String WEEKEND_SCHEDULE = "Weekends";
	
	/** List of available courses. */
	private List<Course> courses;

	/**
     * Initializes the list of courses with predefined data.
     * This method is executed after the controller is constructed.
     */
	@PostConstruct
	public void init() {
		courses = new ArrayList<>();
		courses.add(new Course("Spring Boot", 150, PM_SCHEDULE));
		courses.add(new Course("Python", 300, PM_SCHEDULE));
		courses.add(new Course("Java EE", 250, MORNING_SCHEDULE));
		courses.add(new Course("JavaScript", 150, PM_SCHEDULE));
		courses.add(new Course("Linux", 80, WEEKEND_SCHEDULE));
		courses.add(new Course("Java for Android", 300, MORNING_SCHEDULE));	
	}

	/**
	 * Retrieves the list of available courses in XML format.
	 *
	 * @return A list of available courses.
	 * @author Adriano Díaz Benítez.
	 */
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * Searches for courses whose title contains the specified keyword.
	 *
	 * @param title The keyword used to filter courses by title.
	 * @return A list of courses matching the given title keyword.
	 * @author Adriano Díaz Benítez.
	 */
	@GetMapping(value = "/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> searchCourses(@PathVariable String title) {
		return courses.stream().filter(c -> c.getTitle().contains(title)).toList();
	}

	/**
	 * Retrieves a predefined course in XML format.
	 *
	 * @return A {@code Course} object containing course details.
	 * @author Adriano Díaz Benítez.
	 */
	@GetMapping(value = "/course", produces = MediaType.APPLICATION_XML_VALUE)
	public Course getCourse() {
		return new Course("Java", 100, MORNING_SCHEDULE);
	}

	/**
	 * Deletes a course based on its title.
	 *
	 * @param title The title of the course to be deleted.
	 * @return A {@code ResponseEntity} containing a success message if the course was deleted,
	 *         or a NOT FOUND status if the course was not found.
	 * @author Adriano Díaz Benítez.
	 */
	@DeleteMapping(value = "/{title}")
	public ResponseEntity<String> deleteCourse(@PathVariable String title) {
		boolean removed = courses.removeIf(c -> c.getTitle().equalsIgnoreCase(title));

		if (removed) {
			return ResponseEntity.ok("Course '" + title + "' deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course '" + title + "' not found.");
		}
	} 

	/**
	 * Adds a new course to the list.
	 *
	 * @param course The course object received in the request body.
	 * @return A {@code ResponseEntity} containing a confirmation message
	 *         and a CREATED status upon successful addition.
	 * @author Adriano Díaz Benítez.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> addCourse(@RequestBody Course course) {
		courses.add(course);
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", "Course added successfully!"));
	}

	/**
	 * Updates an existing course based on its title.
	 *
	 * @param title The title of the course to be updated.
	 * @param updatedCourse The new course details received in the request body.
	 * @return A {@code ResponseEntity} containing the updated course if found,
	 *         or a NOT FOUND status if the course does not exist.
	 * @author Adriano Díaz Benítez.
	 */
	@PutMapping(value = "/{title}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> updateCourse(@PathVariable String title, @RequestBody Course updatedCourse) {
		for (Course course : courses) {
			if (course.getTitle().equalsIgnoreCase(title)) {
				course.setTitle(updatedCourse.getTitle());
				course.setLength(updatedCourse.getLength());
				course.setSchedule(updatedCourse.getSchedule());
				return ResponseEntity.ok(course);
			}
		} 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}
