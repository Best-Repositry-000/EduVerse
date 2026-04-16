package com.example.eduverse.Model;

import com.example.eduverse.Enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;

    private String firstName;

    private String lastName;

    private String email;

    private String department;

    @ManyToOne
    private Program program;

    private String programName;

    private Integer level;

    @NotNull
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    private Role userRole;
}
