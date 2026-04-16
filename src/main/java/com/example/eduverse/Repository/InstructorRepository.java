package com.example.eduverse.Repository;

import com.example.eduverse.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, UUID> {
    Optional<Instructor> findByEmail(String email);
}
