package com.microlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.microlearn.controllers" })
public class MicroLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroLearnApplication.class, args);
	}

}
