package com.sairaghava;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.sairaghava.h2.H2Controller;
import com.sairaghava.students.StudentController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
/*- @SpringBootTest Automatically searches for @SpringBootApplication class and use that to start a spring application context */
/*- You can do a quick sanity/smoke test - That is build verification testing with this annotation */
public class SmokeTest {

	@Autowired
	StudentController StudentController;

	@Autowired
	H2Controller H2Controller;

	@Test
	public void contextLoads() {
		assertNotNull(StudentController);
		assertNotNull(H2Controller);
	}

}
