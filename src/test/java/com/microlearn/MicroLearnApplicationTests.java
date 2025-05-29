package com.microlearn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
		mock.perform(delete("/courses/Python")).andDo(print());
	}

	@Test
	@Order(1)
	void testCourses() throws Exception {
		mock.perform(get("/courses")).andDo(print()).andExpect(status().isOk());
	}

}
