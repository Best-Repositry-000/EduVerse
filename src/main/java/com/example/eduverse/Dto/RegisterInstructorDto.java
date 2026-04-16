package com.example.eduverse.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterInstructorDto {
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String password;
}
