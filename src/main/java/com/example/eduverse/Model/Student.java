package com.example.eduverse.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    private Integer level;

    @ManyToOne
    private Program program;

    private String programName;
    
    @NotNull
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

}
