package com.example.eduverse.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AssignGradeRequest {
    private UUID studentId;
    private UUID curriculumCourseId;
    private UUID semesterId;
    private String grade;

}
