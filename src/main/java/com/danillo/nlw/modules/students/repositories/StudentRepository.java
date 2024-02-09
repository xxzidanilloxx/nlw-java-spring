package com.danillo.nlw.modules.students.repositories;

import com.danillo.nlw.modules.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    Optional<Student> findByEmail(String email);
}
