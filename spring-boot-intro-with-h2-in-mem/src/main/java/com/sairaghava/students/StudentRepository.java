package com.sairaghava.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*- @Repository // this is not required as @EnableJPARepositories in your main class scans for all reposiotries i.e., all types that extend from Spring Data's JPA repository hierarchy */

@Transactional(propagation = Propagation.MANDATORY)
// optional in this use-case but just adding to be aware that it must be used
// most of the times
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
