package com.example.eduverse.Controller;

import com.example.eduverse.ServiceImpl.CourseRegistrationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class CourseRegistrationController {
    private final CourseRegistrationServiceImpl courseRegService;

    @PostMapping("/{studentId}")
    public ResponseEntity<String> registerCourses(
            @PathVariable UUID studentId,
            @RequestBody List<Long> curriculumCourseIds
            ){
        courseRegService.registerCourses(studentId, curriculumCourseIds);
        return ResponseEntity.ok("Course registration done!!");
    }

    @PreAuthorize("hasRole('LEVEL_ADVISER')")
    @PutMapping("/approve-all")
    public ResponseEntity<String> approveAll(@RequestParam UUID adviserId) {
        courseRegService.approveAllForLevel(adviserId);
        return ResponseEntity.ok("All registrations approved");
    }

    @PreAuthorize("hasRole('HOD')")
    @PutMapping("/hod/approve-all")
    public ResponseEntity<String> approveAllByHod(Authentication authentication) {
        String email = authentication.getName();
        courseRegService.approveAllByHod(email);
        return ResponseEntity.ok("All level-approved registrations have been finalized");
    }
}
