package com.example.eduverse.Controller;

import com.example.eduverse.Dto.CourseWeekDto;
import com.example.eduverse.Model.CourseWeek;
import com.example.eduverse.ServiceImpl.CourseWeekServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/courses/{Id}/weeks")
@RequiredArgsConstructor
public class CourseWeekController {
    private final CourseWeekServiceImpl serviceImpl;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CourseWeekDto createWeek(
            @PathVariable Long Id,
            @RequestBody CourseWeekDto dto) {
        serviceImpl.createWeek(Id, dto);
        return dto;
    }

    @GetMapping("/get/All")
    public List<CourseWeek> getWeeks(@PathVariable Long Id) {
        return serviceImpl.getWeeksByCourse(Id);
    }

    @PostMapping("/upload/{weekId}")
    public ResponseEntity<String> uploadPdf(
            @PathVariable Long weekId,
            @RequestParam("file") MultipartFile file) throws IOException {

        serviceImpl.uploadPdf(weekId, file);
        return ResponseEntity.ok("PDF uploaded successfully");
    }
}
