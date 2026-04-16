package com.example.eduverse.Controller;

import com.example.eduverse.Model.Course;
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
    public Course createCourse(@RequestBody Course course){
        coursesService.createCourse(course);
        return course;
    }

//    @DeleteMapping("/delete/{courseCode}")
//    public ResponseEntity<Void>  deleteCourse(@PathVariable String courseCode){
//        coursesService.deleteCourseByCourseCode(courseCode);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/all")
//    public List<Course> getAllCourses(){
//        return coursesService.getAllCourses();
//    }
}
