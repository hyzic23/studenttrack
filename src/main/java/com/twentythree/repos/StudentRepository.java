package com.twentythree.repos;

import com.twentythree.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
