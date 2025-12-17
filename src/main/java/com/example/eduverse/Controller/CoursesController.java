package com.example.eduverse.Controller;

import com.example.eduverse.Model.Courses;
import com.example.eduverse.ServiceImpl.CoursesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class CoursesController {
    private final CoursesServiceImpl coursesService;

    @PostMapping("/courses")
    public ResponseEntity<Courses>  createCourse(){
        Courses c = coursesService.createCourse();
        return ResponseEntity.ok(c);
    }
    @DeleteMapping("/courses/{courseCode}")
    public ResponseEntity<String>  deleteCourse(@PathVariable String courseCode){
        return ResponseEntity.ok(coursesService.deleteCourse(courseCode));
    }
}
