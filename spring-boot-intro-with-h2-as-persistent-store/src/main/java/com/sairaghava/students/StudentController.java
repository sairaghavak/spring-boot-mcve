package com.sairaghava.students;

import java.util.List;
import java.util.Optional;
import com.sairaghava.commons.Message;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private Message message;

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public List<Student> getAllStudents() {
    return studentService.getAll();
  }

  @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE })
  @ResponseStatus(HttpStatus.CREATED)
  public Student createStudent(@RequestBody Student student) {
    return studentService.create(student);
    /*- The save operation will never be null */
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<?> getStudent(@PathVariable int id) {
    Optional<Student> student = studentService.get(id);
    message.setMessage("id " + id + " Not found");
    return student.isPresent() ? ResponseEntity.ok(student.get())
        : ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
  public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
    return studentService.update(id, student);
    /*- The save operation will never be null */
  }

  @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  public ResponseEntity<?> deleteStudent(@PathVariable int id) {
    studentService.delete(id);
    message.setMessage("Deleted resouce with id " + id);
    return ResponseEntity.ok(message);
  }
}
