package com.microlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Entry point for the MicroLearn application. This class initializes the Spring
 * Boot framework and configures component scanning.
 * 
 * @author Adriano
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.microlearn.controllers" })
public class MicroLearnApplication {

	/**
	 * Main method that starts the MicroLearn application. It uses
	 * {@link SpringApplication#run(Class, String...)} to bootstrap the application.
	 * 
	 * @param args Command-line arguments for the application (optional).
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroLearnApplication.class, args);
	}

}
