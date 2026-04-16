package com.example.eduverse.Model;

import com.example.eduverse.Enums.Category;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "Binary(16)")
    private UUID Id;

    private String courseCode;
    private String title;
    private String overview;
    private String description;
    private String instructorName;
    private Category category;
    private String department;
    private int creditUnits;
    private String outcome;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CourseWeek> syllabus = new ArrayList<>();

    @ManyToMany(mappedBy = "majorCourses")
    private List<CareerOutcome> careerOutcomes;
}