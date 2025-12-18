package com.example.eduverse.Repositry;

import com.example.eduverse.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Long> {
    void deleteCourseByCourseCode(String courseCode);
    List<Courses> findAll();
}
