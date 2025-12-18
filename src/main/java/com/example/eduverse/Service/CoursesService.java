package com.example.eduverse.Service;

import com.example.eduverse.Model.Courses;

import java.util.List;

public interface CoursesService {
    void createCourse(Courses course);
//    public void editCourse();
    void deleteCourseByCourseCode(String courseCode);
    List<Courses> getAllCourses();
}
