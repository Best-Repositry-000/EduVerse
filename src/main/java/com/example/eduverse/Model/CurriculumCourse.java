package com.example.eduverse.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "Curriculum_Courses",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"curriculum_id", "course_id"})
    })
@Getter
@Setter
public class CurriculumCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @ManyToOne
    private Curriculum curriculum;

    @ManyToOne
    private Course course;

    private Integer level;

    private String semester;
}
