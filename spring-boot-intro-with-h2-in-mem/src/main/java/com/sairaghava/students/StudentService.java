package com.sairaghava.students;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  // @Transactional - Used to set and define our Transactional boundary
  /*-
    We don't need a @Transactional here, as we are dealing with just one dataRepository, if we are spanning multiple repositories then @Transactional is recommended
  
    Already, JPA along with Hibernate in spring-boot does the job of db, connection-pooling and operation commits etc.
  
    This @Transactional is JTA specific and for distributed transactions
  */
  public List<Student> getAll() {
    return studentRepository.findAll();
  }

  // @Transactional
  public Student create(Student student) {
    return studentRepository.save(student);
  }

  // @Transactional
  public Optional<Student> get(int id) {
    return studentRepository.findById(id);
    /*- findOne(type) -> is like a search and returns one matching result, otherwise null */
  }

  // @Transactional
  public Student update(int id, Student student) {
    student.setId(id);
    /*- If you want to prevent user from updating it again and again with same "name property", you can search with this id and compare that name with this name and return 409 conflict, thereby you prevent writing to DB unnecessarily, but you have to read i.e., do a searchById, read is not costly */
    return studentRepository.save(student);
    /*- In spring DataJPA save is used for both and update and created, but it checks internally if the resource aleady exists or not, if yes, it updates using merge, otherwise it tries to create a new resource using save */
  }

  // @Transactional
  public void delete(int id) {
    studentRepository.deleteById(id);
  }

}
