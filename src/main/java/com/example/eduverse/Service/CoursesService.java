package com.example.eduverse.Service;

import com.example.eduverse.Model.Courses;

public interface CoursesService {
    public Courses createCourse();
    public void editCourse();
    public String deleteCourse(String courseCode);
}
