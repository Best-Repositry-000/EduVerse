package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Dto.CourseWeekDto;
import com.example.eduverse.Model.Course;
import com.example.eduverse.Model.CourseWeek;
import com.example.eduverse.Repository.CourseRepository;
import com.example.eduverse.Repository.CourseWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseWeekServiceImpl{
    private final CourseWeekRepository weekRepository;
    private final CourseRepository courseRepository;

    public void createWeek(Long Id, CourseWeekDto requestDto) {

//        Course course = courseRepository.existsById()
//                .orElseThrow(() -> new RuntimeException("Course not found"));

        CourseWeek newWeek = new CourseWeek();
        newWeek.setWeekNo(requestDto.getWeekNo());
        newWeek.setTitle(requestDto.getTitle());
        newWeek.setDescription(requestDto.getDescription());
//        newWeek.setCourse(course);
        weekRepository.save(newWeek);

    }

    public List<CourseWeek> getWeeksByCourse(Long Id) {
        return weekRepository.findByIdOrderByWeekNoAsc(Id);
    }

    public void uploadPdf(Long Id, MultipartFile file) throws IOException {
        CourseWeek week = weekRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Week not found or created."));
        String fileName = UUID.randomUUID() + ".pdf";
        Path path = Paths.get("uploads/" + fileName);

        Files.write(path, file.getBytes());

        week.setPdfPath(path.toString());
        weekRepository.save(week);
    }
}
