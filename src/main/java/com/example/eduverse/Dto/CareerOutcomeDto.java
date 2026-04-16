package com.example.eduverse.Dto;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CareerOutcomeDto {
    private String jobTitle;
    private String jobDescription;
    private List<CourseSummaryDto> majorCourses;
}
