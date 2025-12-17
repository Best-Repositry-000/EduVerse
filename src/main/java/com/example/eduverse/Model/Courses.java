package com.example.eduverse.Model;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Courses {
    private String title;
    private String courseCode;
    private String overview;
    private String description;
    private String instructorName;
    private String category;
    private List<CourseWeek> syllabus;
    private String outcome;
}