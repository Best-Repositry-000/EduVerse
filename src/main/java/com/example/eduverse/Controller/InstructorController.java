package com.example.eduverse.Controller;

import com.example.eduverse.Dto.LoginDto;
import com.example.eduverse.Dto.RegisterInstructorDto;
import com.example.eduverse.Model.Instructor;
import com.example.eduverse.ServiceImpl.InstructorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorServiceImpl instructorService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody RegisterInstructorDto user){
        instructorService.createInstructor(user);
        return ResponseEntity.ok("User successfully created");
    }

    @GetMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginDto user){
        instructorService.login(user);
        return ResponseEntity.ok(instructorService.login(user));
    }

    // Logic that is called to change the role from a lecturer to a level adviser and HOD
    @PutMapping("/level-adviser")
    public ResponseEntity<?> makeLevelAdviser(@RequestBody Instructor instructor){
        instructorService.makeLevelAdviser(instructor);
        return ResponseEntity.ok("Role updated");
    }

    @PutMapping("/HOD")
    public ResponseEntity<?> makeHOD(@RequestBody Instructor instructor){
        instructorService.makeHOD(instructor);
        return ResponseEntity.ok("Role updated");
    }
}
