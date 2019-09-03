package com.sairaghava.students;

import org.springframework.data.jpa.repository.JpaRepository;

/*- @Repository // this is not required as @EnableJPARepositories in your main class scans for all reposiotries i.e., all types that extend from Spring Data JPA repository hierarchy */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
