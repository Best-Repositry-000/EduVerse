package com.example.eduverse.Repository;

import com.example.eduverse.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findById(UUID studentId);
    Optional<Student> findByEmail(String email);
}
