package com.example.eduverse.ServiceImpl;

import com.example.eduverse.Dto.*;
import com.example.eduverse.Model.CareerOutcome;
import com.example.eduverse.Model.Program;
import com.example.eduverse.Model.ProgramOverview;
import com.example.eduverse.Repository.ProgramRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProgramOverviewServiceImpl{
    private final ProgramRepository programRepo;


    public ProgramOverviewDto getOverview(UUID programId) {
        Program program = programRepo.findById(programId)
                .orElseThrow(() -> new EntityNotFoundException("Program not found"));

        ProgramOverview profile = program.getOverview();

        return mapToDto(program, profile);
    }

    private ProgramOverviewDto mapToDto(Program program, ProgramOverview profile) {

        ProgramOverviewDto dto = new ProgramOverviewDto();

        dto.setProgramName(program.getName());
        dto.setDescription(profile.getDescription());

        dto.setBadges(buildBadges(profile));

        dto.setLearningOutcomes(
                profile.getLearningOutcomes()
                        .stream()
                        .map(lo -> new LearningOutcomeDto(lo.getTitle(), lo.getDescription()))
                        .toList()
        );
        dto.setGraduationRequirements(
                profile.getGraduationRequirements()
                        .stream()
                        .map(gr -> new GraduationRequirementDto(
                                gr.getRequirementName(),
                                gr.getCredits(),
                                gr.getDetails()
                        ))
                        .toList()
        );
        dto.setResources(
                profile.getResources()
                        .stream()
                        .map(resource -> new ResourceDto(
                                resource.getResourceName(),
                                resource.getPdfPath()
                        ))
                        .toList()
        );
        dto.setCareerOutcomes(
                profile.getCareerOutcomes()
                        .stream()
                        .map(this::mapCareerOutcome)
                        .toList()
        );

        dto.setMinGPA(profile.getMinGPA());
        dto.setMinCGPA(profile.getMinCGPA());
        dto.setResidencyCreditsRequired(profile.getResidencyCreditsRequired());

        return dto;
    }
    private List<String> buildBadges(ProgramOverview profile) {
        List<String> badges = new ArrayList<>();

        if (profile.isAbetAccredited()) badges.add("ABET Accredited");
        if (profile.isTopRanked()) badges.add("Top Ranked Program");
        if (profile.isInternationallyRecognized()) badges.add("Internationally Recognized");

        return badges;
    }
    private CareerOutcomeDto mapCareerOutcome(CareerOutcome career) {

        return new CareerOutcomeDto(
                career.getJobTitle(),
                career.getJobDescription(),
                career.getMajorCourses()
                        .stream()
                        .map(course -> new CourseSummaryDto(
                                course.getCourseCode(),
                                course.getTitle()
                        ))
                        .toList()
        );
    }
}