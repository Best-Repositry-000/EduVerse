package com.example.eduverse.Controller;

import com.example.eduverse.Model.Courses;
import com.example.eduverse.ServiceImpl.CoursesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CoursesController {
    private final CoursesServiceImpl coursesService;

    @PostMapping("/create")
    public Courses  createCourse(@RequestBody Courses course){
        coursesService.createCourse(course);
        return course;
    }
    @DeleteMapping("/delete/{courseCode}")
    public ResponseEntity<Void>  deleteCourse(@PathVariable String courseCode){
        coursesService.deleteCourseByCourseCode(courseCode);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/all")
    public List<Courses> getAllCourses(){
        return coursesService.getAllCourses();
    }
}
