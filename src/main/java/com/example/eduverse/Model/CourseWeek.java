package com.example.eduverse.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table( name = "Course_Week",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"course_id", "week_order"})
        }
)
public class CourseWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "week_order", nullable = false)
    private Integer weekNo;

    private String title;

    private String description;

    @Column(name = "pdf_path")
    private String pdfPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}