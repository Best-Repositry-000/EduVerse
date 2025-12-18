package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Model.CourseWeek;
import com.example.eduverse.Model.Courses;
import com.example.eduverse.Repositry.CoursesRepository;
import com.example.eduverse.Service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository;

    @Override
    public void createCourse(Courses course) {
        course.setCourseCode(course.getCourseCode());
        course.setTitle(course.getTitle());
        course.setOverview(course.getOverview());
        course.setCategory(course.getCategory());
        course.setDescription(course.getDescription());
        course.setInstructorName(course.getInstructorName());
        course.setOutcome(course.getOutcome());
        course.setSyllabus(course.getSyllabus());
        if (course.getSyllabus() != null) {
            for (CourseWeek week : course.getSyllabus()) {
                week.setCourse(course);
            }
        }
        coursesRepository.save(course);
    }

    @Override
    public void deleteCourseByCourseCode(String courseCode) {
        coursesRepository.deleteCourseByCourseCode(courseCode);
    }

    @Override
    public List<Courses> getAllCourses() {
        return coursesRepository.findAll();
    }
}
