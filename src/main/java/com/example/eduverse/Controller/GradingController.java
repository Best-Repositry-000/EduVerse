package com.example.eduverse.Controller;

import com.example.eduverse.Dto.AssignGradeRequest;
import com.example.eduverse.ServiceImpl.GradingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grade")
@RequiredArgsConstructor
public class GradingController {
    private final GradingServiceImpl gradingService;

    @PutMapping("/assign")
    public ResponseEntity<String> assignGrade(@RequestBody AssignGradeRequest request) {

        gradingService.assignGrade(
                request.getStudentId(),
                request.getCurriculumCourseId(),
                request.getSemesterId(),
                request.getGrade()
        );
        return ResponseEntity.ok("Grade assigned successfully");
    }
}
