package com.example.eduverse.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseWeek {
    private String courseId;
    private String weekNo;
    private String title;
    private String description;
}
