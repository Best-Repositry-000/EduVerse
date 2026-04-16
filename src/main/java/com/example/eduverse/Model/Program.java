package com.example.eduverse.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Data
@Table(name = "Programs")
@Getter
@Setter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    private ProgramOverview Overview;
}
