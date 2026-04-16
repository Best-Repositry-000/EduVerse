package com.example.eduverse.Dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GraduationRequirementDto {
    private String requirementName;
    private Integer credits;
    private String details;
}
