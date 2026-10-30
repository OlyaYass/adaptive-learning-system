package ru.rosbiotech.adaptive.academic.competency.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.academic.competency.application.CompetencyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competencies")
public class CompetencyController {

    private final CompetencyService service;

    public CompetencyController(
            CompetencyService service
    ) {
        this.service = service;
    }

    @PostMapping
    public CompetencyResponse createCompetency(
            @Valid @RequestBody CreateCompetencyRequest request
    ) {
        return service.createCompetency(request);
    }

    @GetMapping
    public List<CompetencyResponse> getAll() {
        return service.getAllCompetencies();
    }

    @PostMapping("/indicators")
    public CompetencyIndicatorResponse createIndicator(
            @Valid
            @RequestBody CreateCompetencyIndicatorRequest request
    ) {
        return service.createIndicator(request);
    }

    @GetMapping("/{competencyId}/indicators")
    public List<CompetencyIndicatorResponse> getIndicators(
            @PathVariable Long competencyId
    ) {
        return service.getIndicators(competencyId);
    }
}