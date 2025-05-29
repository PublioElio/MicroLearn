package com.microlearn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class MicroLearnApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@Order(0)
	void deleteCourse() throws Exception {
		mock.perform(delete("/courses/Python")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	@Order(1)
	void testCourses() throws Exception {
		mock.perform(get("/courses")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	@Order(2)
	void createCourse() throws Exception {
		mock.perform(post("/courses").contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\":\"Angular 10\", \"length\":40, \"schedule\":\"afternoon\"}")).andDo(print())
				.andExpect(status().isCreated());
	}

	@Test
	@Order(3)
	void updateCourse() throws Exception {
		mock.perform(put("/courses/Angular 10").contentType(MediaType.APPLICATION_JSON)
				.content("{\"title\":\"Angular 10\", \"length\":60, \"schedule\":\"afternoon\"}")).andDo(print())
				.andExpect(status().isOk());
	}

}
