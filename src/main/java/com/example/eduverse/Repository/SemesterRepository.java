package com.example.eduverse.Repository;

import com.example.eduverse.Model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Long> {
    Optional<Semester> findByActiveTrue();
    Optional<Semester> findById(UUID semesterId);
}