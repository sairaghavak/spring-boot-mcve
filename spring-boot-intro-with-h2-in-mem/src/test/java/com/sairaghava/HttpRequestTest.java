package com.sairaghava;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.sairaghava.h2.H2dbConfig;
import com.sairaghava.students.Student;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
/*- This apporach is gonna start a server with random port at the background and verifies */
public class HttpRequestTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  private H2dbConfig h2dbConfig;
  private List<Student> students;

  @BeforeAll
  public void setup() {
    h2dbConfig = testRestTemplate
        .getForEntity("http://localhost:" + port + "/srk/h2/default/properties", H2dbConfig.class).getBody();
    students = testRestTemplate.getForEntity("http://localhost:" + port + "/srk/students", List.class).getBody();
    System.out.println(h2dbConfig == null);
  }

  @Test
  public void isH2ConfigNull() {
    assertNotNull(h2dbConfig);
  }

  @Test
  public void testH2ContextPath() {
    assertEquals(h2dbConfig.getConsoleContextPath(), "/h2db-console");
  }

  @Test
  public void testIfGetStudentsIsNotNull() {
    assertNotNull(students);
  }

  @Test
  public void checkIfStudentsIsEmptyInitially() {
    assertEquals(2, students
        .size());/*- check student size as 2 because this test suite is just like launching a spring boot app with spring-boot:run command where in the student table along with data is created in it*/
  }

}