package com.example.eduverse.Repositry;

import com.example.eduverse.Model.Courses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends CrudRepository<Courses, String> {

}
