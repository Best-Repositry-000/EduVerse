package com.example.eduverse.Repository;

import com.example.eduverse.Model.Course;
import com.example.eduverse.Model.Curriculum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
}
