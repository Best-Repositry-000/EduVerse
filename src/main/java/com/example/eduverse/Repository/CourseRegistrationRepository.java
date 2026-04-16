package com.example.eduverse.Repository;

import com.example.eduverse.Enums.ProgressionStatus;
import com.example.eduverse.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    boolean existsByStudentAndCourseAndSemester(
            Student student,
            CurriculumCourse curriculumCourse,
            Semester semester
    );

    Optional<CourseRegistration> findByStudentAndCourseAndSemester(
            Student student,
            CurriculumCourse curriculumCourse,
            Semester semester
    );

    List<CourseRegistration> findByStudentProgramAndStudentLevelAndSemesterAndStatus(
            Program program,
            Integer level,
            Semester semester,
            ProgressionStatus status
    );

    List<CourseRegistration> findByStudentProgramAndSemesterAndStatus(
            Program program,
            Semester semester,
            ProgressionStatus status
    );
}
