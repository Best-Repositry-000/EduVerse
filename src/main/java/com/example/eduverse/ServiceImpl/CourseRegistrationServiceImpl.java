package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Enums.ProgressionStatus;
import com.example.eduverse.Enums.Role;
import com.example.eduverse.Model.*;
import com.example.eduverse.Repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseRegistrationServiceImpl {
    private final InstructorRepository instructorRepo;
    private final StudentRepository studentRepository;
    private final CurriculumRepository curriculumRepository;
    private final CurriculumCourseRepository curriculumCourseRepository;
    private final SemesterRepository semesterRepository;
    private final CourseRegistrationRepository courseRegistrationRepository;

    @Transactional
    public void registerCourses(UUID studentId, List<Long> curriculumCourseIds) {

        // 1. Get student
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 2. Get student context
        Program program = student.getProgram();
        Integer level = student.getLevel();
        String programName = program.getName();

        // 3. Get current semester
        Semester semester = semesterRepository.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("No active semester"));

        // 4. Get curriculum
        Curriculum curriculum = curriculumRepository.findByProgram(programName)
                .orElseThrow(() -> new RuntimeException("Curriculum not found"));

        // 5. Get allowed curriculum courses (method naming version)
        List<CurriculumCourse> allowedCourses =
                curriculumCourseRepository.findByCurriculumAndLevelAndSemester(
                        curriculum, level, semester
                );

        // Convert to Map for quick lookup
        Map<UUID, CurriculumCourse> allowedMap = allowedCourses.stream()
                .collect(Collectors.toMap(CurriculumCourse::getId, cc -> cc));

        // 6. Preparing a list of registration instances
        List<CourseRegistration> registrationsToSave = new ArrayList<>();

        for (Long ccId : curriculumCourseIds) {

            CurriculumCourse cc = allowedMap.get(ccId);

            if (cc == null) {
                throw new RuntimeException("Invalid course selection");
            }

            // Check duplicate registration
            boolean alreadyRegistered =
                    courseRegistrationRepository.existsByStudentAndCourseAndSemester(
                            student, cc, semester
                    );

            if (alreadyRegistered) {
                continue; // skip duplicates
            }

            // Create registration
            CourseRegistration registration = new CourseRegistration();
            registration.setStudent(student);
            registration.setCourse(cc);
            registration.setSemester(semester);
            registration.setGrade(null);
            registration.setStatus(ProgressionStatus.PENDING);

            registrationsToSave.add(registration);
        }

        // 7. Save all at once
        if (!registrationsToSave.isEmpty()) {
            courseRegistrationRepository.saveAll(registrationsToSave);
        }
    }

    @Transactional
    public void approveAllForLevel(UUID adviserId) {

        // 1. Get adviser
        Instructor adviser = instructorRepo.findById(adviserId)
                .orElseThrow(() -> new RuntimeException("Adviser not found"));

        Program program = adviser.getProgram();
        Integer level = adviser.getLevel();

        // 2. Get current semester
        Semester semester = semesterRepository.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("No active semester"));

        // 3. Fetch pending registrations
        List<CourseRegistration> registrations =
                courseRegistrationRepository
                        .findByStudentProgramAndStudentLevelAndSemesterAndStatus(
                                program,
                                level,
                                semester,
                                ProgressionStatus.PENDING
                        );

        // 4. Approve all
        for (CourseRegistration reg : registrations) {
            reg.setStatus(ProgressionStatus.APPROVED);
        }

        // 5. Save all
        courseRegistrationRepository.saveAll(registrations);
    }

    @Transactional
    public void approveAllByHod(String hodEmail) {

        // 1. Get HOD (Instructor with role HOD)
        Instructor hod = instructorRepo.findByEmail(hodEmail)
                .orElseThrow(() -> new RuntimeException("HOD not found"));

        if (hod.getUserRole() != Role.HOD) {
            throw new RuntimeException("Unauthorized: Not a HOD");
        }

        // 2. Get program (VERY IMPORTANT)
        Program program = hod.getProgram();

        // 3. Get current semester
        Semester semester = semesterRepository.findByActiveTrue()
                .orElseThrow(() -> new RuntimeException("No active semester"));

        // 4. Get all LEVEL_APPROVED registrations
        List<CourseRegistration> registrations =
                courseRegistrationRepository
                        .findByStudentProgramAndSemesterAndStatus(
                                program,
                                semester,
                                ProgressionStatus.APPROVED
                        );

        // 5. Approve all → REGISTERED
        for (CourseRegistration reg : registrations) {
            reg.setStatus(ProgressionStatus.REGISTERED);
        }

        // 6. Save all
        courseRegistrationRepository.saveAll(registrations);
    }
}
