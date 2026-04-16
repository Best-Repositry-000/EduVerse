//package com.example.eduverse.Model;
//
//import com.example.eduverse.Enums.Grade;
//import com.example.eduverse.Enums.ProgressionStatus;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Entity
//@Getter
//@Setter
//@Data
//public class CourseProgression {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    // WHO
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id", nullable = false)
//    private Student student;
//
//    // WHAT COURSE
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "course_id", nullable = false)
//    private Course course;
//
////    OPTIONAL: link to registration
//    @OneToOne
//    @JoinColumn(name = "registration_id")
//    private CourseRegistration courseRegistration;
//
//    // ACADEMIC CONTEXT
//    private int level;              // e.g. 200, 300
//    private int semester;           // 1 or 2
//    private String academicSession; // 2024/2025
//
//    @Enumerated(EnumType.STRING)
//    private Grade resultStatus;
//
//    @Enumerated(EnumType.STRING)
//    private ProgressionStatus progressStatus;
//
//    private LocalDateTime registeredAt;
//    private LocalDateTime gradedAt;
//}
