package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Model.Course;
import com.example.eduverse.Repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl{
    private final CourseRepository coursesRepository;

    public void createCourse(Course course) {
        course.setCourseCode(course.getCourseCode());
        course.setTitle(course.getTitle());
        course.setOverview(course.getOverview());
        course.setCategory(course.getCategory());
        // Line above stays for now
        course.setDescription(course.getDescription());
        course.setInstructorName(course.getInstructorName());
        course.setOutcome(course.getOutcome());
        course.setDepartment(course.getDepartment());
        course.setCreditUnits(course.getCreditUnits());
        coursesRepository.save(course);
    }

//    @Override
//    public void deleteCourseByCourseCode(String courseCode) {
//        coursesRepository.deleteCourseByCourseCode(courseCode);
//    }
//
//    @Override
//    public List<Course> getAllCourses() {
//        return coursesRepository.findAll();
//    }
}
