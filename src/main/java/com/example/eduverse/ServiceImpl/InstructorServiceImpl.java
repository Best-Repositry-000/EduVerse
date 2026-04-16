package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Config.PasswordEncoderConfig;
import com.example.eduverse.Dto.LoginDto;
import com.example.eduverse.Dto.RegisterInstructorDto;
import com.example.eduverse.Enums.Role;
import com.example.eduverse.Model.Instructor;
import com.example.eduverse.Repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl{
    private final InstructorRepository instructorRepo;
    private final PasswordEncoderConfig passwordEncoder;

    public void createInstructor(RegisterInstructorDto registerInstructor) {

        Instructor instructor = new Instructor();
        instructor.setFirstName(registerInstructor.getFirstName());
        instructor.setLastName(registerInstructor.getLastName());
        instructor.setEmail(registerInstructor.getEmail());
        instructor.setDepartment(registerInstructor.getDepartment());
        instructor.setUserRole(Role.LECTURER);
        String password = passwordEncoder.passwordEncoder().encode(registerInstructor.getPassword());
        instructor.setPassword(password);

        instructorRepo.save(instructor);
    }

    public String login(LoginDto instructor) {
        Instructor existing = instructorRepo.findByEmail(String.valueOf(instructor.getEmail()))
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        if (!existing.getPassword().equals(instructor.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return "User successfully logged in";
    }

    public void makeLevelAdviser(Instructor instructor){
        Instructor existing = instructorRepo.findByEmail(instructor.getEmail()).
                orElseThrow(() -> new RuntimeException("User does not exist"));

        existing.setUserRole(Role.LEVEL_ADVISER);
        existing.setProgramName(instructor.getProgramName());
        existing.setLevel(instructor.getLevel());
        instructorRepo.save(existing);
    }

    public void makeHOD(Instructor instructor){
        Instructor existing = instructorRepo.findByEmail(instructor.getEmail()).
                orElseThrow(() -> new RuntimeException("User does not exist"));

        existing.setUserRole(Role.HOD);
        existing.setProgramName(instructor.getProgramName());
        instructorRepo.save(existing);
    }
}
