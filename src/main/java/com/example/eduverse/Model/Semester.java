package com.example.eduverse.Model;

import com.example.eduverse.Enums.Term;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Semesters")
@Getter
@Setter
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Term semesterTerm;

    private String academicSession;

    private LocalDate startDate;
    private LocalDate endDate;

    private boolean active;
}
