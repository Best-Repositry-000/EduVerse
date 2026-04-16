package com.example.eduverse.Controller;

import com.example.eduverse.Dto.LoginDto;
import com.example.eduverse.Dto.RegisterStudentDto;
import com.example.eduverse.ServiceImpl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterStudentDto user){
        studentService.createUser(user);
        return ResponseEntity.ok("User successfully created");
    }

    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDto user){
        studentService.login(user);
        return ResponseEntity.ok(studentService.login(user));
    }
}
