package com.example.eduverse.Repository;

import com.example.eduverse.Model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProgramRepository extends JpaRepository<Program, UUID> {
    @Query("""
    SELECT p FROM Program p
    LEFT JOIN FETCH p.Overview ov
    LEFT JOIN FETCH ov.learningOutcomes
    LEFT JOIN FETCH ov.graduationRequirements
    LEFT JOIN FETCH ov.careerOutcomes co
    LEFT JOIN FETCH co.majorCourses
    LEFT JOIN FETCH ov.resources
    WHERE p.id = :programId
""")
    Optional<Program> findById(UUID uuid);

    Optional<Program> findByName(String name);
}
