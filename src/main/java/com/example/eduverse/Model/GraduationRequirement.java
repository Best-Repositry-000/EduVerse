package com.example.eduverse.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
@Getter
public class GraduationRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requirementName;
    private Integer credits;
    private String details;

    @ManyToOne
    private ProgramOverview programOverview;
}
