package com.example.eduverse.Controller;

import com.example.eduverse.Dto.ProgramOverviewDto;
import com.example.eduverse.ServiceImpl.ProgramOverviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/program/{programId}")
@RequiredArgsConstructor
public class ProgramOverviewController {
    private final ProgramOverviewServiceImpl service;

    @GetMapping("/overview")
    public ProgramOverviewDto getProgramOverview(@PathVariable UUID programId) {
        return service.getOverview(programId);
    }
}
