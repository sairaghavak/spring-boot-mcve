package com.sairaghava;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sairaghava.commons.Message;
import com.sairaghava.students.Student;
import com.sairaghava.students.StudentController;
import com.sairaghava.students.StudentService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = StudentController.class)
/*- This will load only the declared controllers, but not @service and @Repositories or @Components etc*/
@TestInstance(Lifecycle.PER_CLASS)
public class RestEndPointTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudentService studentService;

  @MockBean
  private Message message;

  private ObjectMapper mapper;

  @BeforeAll
  public void setup() {
    mapper = new ObjectMapper();
  }

  @Test
  public void test_createStudent() throws Exception {
    // given
    Student student = new Student();
    student.setName("sairaghava");

    // when condition
    when(this.studentService.create(any(Student.class))).thenReturn(student);

    String requestInputAsString = mapper.writeValueAsString(student);
    String requestOuputAsString = "<Student><id>0</id><name>sairaghava</name></Student>";

    // when and then
    ResultActions resultActions = mockMvc
        .perform(MockMvcRequestBuilders.post("/students").contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(requestInputAsString).characterEncoding(StandardCharsets.UTF_8.name()));
    System.out.println("response = " + resultActions.andReturn().getResponse().getContentAsString());

    resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.content()
            .contentType(MediaType.APPLICATION_XML_VALUE + ";charset=" + StandardCharsets.UTF_8.name()))
        .andExpect(MockMvcResultMatchers.content().string(requestOuputAsString));

    System.out.println("MockMvcResultMatchers.content() " + MockMvcResultMatchers.content());
  }

}