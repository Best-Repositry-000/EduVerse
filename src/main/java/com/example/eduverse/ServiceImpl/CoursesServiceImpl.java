package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Model.Courses;
import com.example.eduverse.Repositry.CoursesRepository;
import com.example.eduverse.Service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository;

    @Override
    public Courses createCourse() {
        Courses course = new Courses();
        course.setCourseCode(course.getCourseCode());
        course.setTitle(course.getTitle());
        course.setOverview(course.getOverview());
        course.setCategory(course.getCategory());
        course.setDescription(course.getDescription());
        course.setInstructorName(course.getInstructorName());
        course.setOutcome(course.getOutcome());
        course.setSyllabus(course.getSyllabus());
        coursesRepository.save(course);
        return course;
    }

    @Override
    public void editCourse() {

    }

    @Override
    public String deleteCourse(String courseCode) {
        if (coursesRepository.existsById(courseCode)){
            coursesRepository.deleteById(courseCode);
        }
        else{
            throw new RuntimeException("Course with Id " + courseCode + " does not exist");
        }
        return "Course successfully deleted";
    }
}
