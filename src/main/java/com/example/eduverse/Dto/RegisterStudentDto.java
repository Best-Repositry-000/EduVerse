package com.example.eduverse.Dto;

import com.example.eduverse.Model.Program;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class RegisterStudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String programName;
    private Integer level;
}
