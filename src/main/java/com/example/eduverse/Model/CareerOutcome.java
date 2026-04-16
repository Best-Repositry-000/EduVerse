package com.example.eduverse.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class CareerOutcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTitle;
    private String jobDescription;

    @ManyToMany
    @JoinTable(
            name = "majorCourses",
            joinColumns = @JoinColumn(name = "career_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> majorCourses;

    @ManyToOne
    private ProgramOverview programOverview;
}
