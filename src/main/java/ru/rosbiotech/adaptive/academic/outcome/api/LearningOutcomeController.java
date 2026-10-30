package ru.rosbiotech.adaptive.academic.outcome.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.academic.outcome.application.LearningOutcomeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/learning-outcomes")
public class LearningOutcomeController {

    private final LearningOutcomeService service;

    public LearningOutcomeController(
            LearningOutcomeService service
    ) {
        this.service = service;
    }

    @PostMapping
    public LearningOutcomeResponse create(
            @Valid @RequestBody CreateLearningOutcomeRequest request
    ) {
        return service.create(request);
    }

    @GetMapping
    public List<LearningOutcomeResponse> getByDiscipline(
            @RequestParam Long programDisciplineId
    ) {
        return service.getByDiscipline(programDisciplineId);
    }
}