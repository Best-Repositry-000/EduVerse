package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Enums.Grade;
import com.example.eduverse.Enums.ProgressionStatus;
import com.example.eduverse.Model.CourseRegistration;
import com.example.eduverse.Model.CurriculumCourse;
import com.example.eduverse.Model.Semester;
import com.example.eduverse.Model.Student;
import com.example.eduverse.Repository.CourseRegistrationRepository;
import com.example.eduverse.Repository.CurriculumCourseRepository;
import com.example.eduverse.Repository.SemesterRepository;
import com.example.eduverse.Repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GradingServiceImpl {
    private final StudentRepository studentRepository;
    private final CurriculumCourseRepository  curriculumCourseRepository;
    private final SemesterRepository semesterRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @Transactional
    public void assignGrade(UUID studentId, UUID curriculumCourseId, UUID semesterId, String gradeInput) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        CurriculumCourse curriculumCourse = curriculumCourseRepository.findById(curriculumCourseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Semester semester = semesterRepository.findById(semesterId)
                .orElseThrow(() -> new RuntimeException("Semester not found"));

        CourseRegistration registration =
                courseRegistrationRepository
                        .findByStudentAndCourseAndSemester(student, curriculumCourse, semester)
                        .orElseThrow(() -> new RuntimeException("Registration not found"));

        // Prevent double grading
        if (registration.getGrade() != null) {
            throw new RuntimeException("Grade already assigned");
        }

        // Convert to enum
        Grade grade;
        try {
            grade = Grade.valueOf(gradeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid grade");
        }

        // Assign grade
        registration.setGrade(grade);

        // Determine pass/fail
        if (grade == Grade.F) {
            registration.setStatus(ProgressionStatus.CARRIED_OVER);
        } else {
            registration.setStatus(ProgressionStatus.CLEARED);
        }

    }
}
