package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Dto.LoginDto;
import com.example.eduverse.Dto.RegisterStudentDto;
import com.example.eduverse.Model.Student;
import com.example.eduverse.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl{
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;


    public void createUser(RegisterStudentDto registerUser) {

        Student newStudent = new Student();
        newStudent.setFirstName(registerUser.getFirstName());
        newStudent.setLastName(registerUser.getLastName());
        newStudent.setProgramName(registerUser.getProgramName());
        newStudent.setLevel(registerUser.getLevel());
        newStudent.setEmail(registerUser.getEmail());
        String password = passwordEncoder.encode(registerUser.getPassword());
        newStudent.setPassword(password);

        studentRepository.save(newStudent);
    }

    public String login(LoginDto user) {
        Student existing = studentRepository.findByEmail(String.valueOf(user.getEmail()))
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        if (!existing.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return "User logged in successfully";
    }
}
