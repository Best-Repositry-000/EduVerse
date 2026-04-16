package com.example.eduverse.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ProgramOverviewDto {

    private String universityName;
    private String programName;
    private String description;

    private List<String> badges;

    private List<LearningOutcomeDto> learningOutcomes;
    private List<GraduationRequirementDto> graduationRequirements;
    private List<CareerOutcomeDto> careerOutcomes;
    private List<ResourceDto>  resources;

    private Double minGPA;
    private Double minCGPA;
    private Integer residencyCreditsRequired;
}
