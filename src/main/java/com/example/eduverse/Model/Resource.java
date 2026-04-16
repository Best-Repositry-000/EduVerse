package com.example.eduverse.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceName;

    @Column(name = "pdf_path")
    private String pdfPath;

    @ManyToOne
    private ProgramOverview programOverview;
}
