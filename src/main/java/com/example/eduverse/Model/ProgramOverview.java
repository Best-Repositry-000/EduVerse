package com.example.eduverse.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
public class ProgramOverview {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID overviewId;

    private String description;
    private Integer residencyCreditsRequired;

//    Badges
    private boolean abetAccredited;
    private boolean topRanked;
    private boolean internationallyRecognized;

    private Double minGPA;
    private Double minCGPA;

    @OneToOne
    private Program program;

    @OneToMany(mappedBy = "programOverview", cascade = CascadeType.ALL)
    private List<LearningOutcome> learningOutcomes;

    @OneToMany(mappedBy = "programOverview", cascade = CascadeType.ALL)
    private List<GraduationRequirement> graduationRequirements;

    @OneToMany(mappedBy = "programOverview", cascade = CascadeType.ALL)
    private List<CareerOutcome> careerOutcomes;

    @OneToMany(mappedBy = "programOverview", cascade = CascadeType.ALL)
    private List<Resource> resources;
}
