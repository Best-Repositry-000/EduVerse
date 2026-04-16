package com.example.eduverse.Repository;

import com.example.eduverse.Model.Curriculum;
import com.example.eduverse.Model.CurriculumCourse;
import com.example.eduverse.Model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurriculumCourseRepository extends JpaRepository<CurriculumCourse, UUID> {
    List<CurriculumCourse> findByCurriculumAndLevelAndSemester(
            Curriculum curriculum,
            Integer level,
            Semester semester
    );

    Optional<CurriculumCourse> findById(UUID curriculumCourseId);
}