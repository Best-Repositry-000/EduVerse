package com.example.eduverse.Model;

import com.example.eduverse.Enums.Grade;
import com.example.eduverse.Enums.ProgressionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
//@Table(name = "course_registrations",
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = {"student_id", "course_id", "semester_id"})
//        })
@Getter
@Setter
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Student student;

    @ManyToOne(optional = false)
    private CurriculumCourse course;

    @ManyToOne(optional = false)
    private Semester semester;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private ProgressionStatus status;
}
