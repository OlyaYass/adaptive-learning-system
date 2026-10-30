package ru.rosbiotech.adaptive.academic.semester.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.academic.semester.application.DisciplineSemesterService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/semesters")
public class DisciplineSemesterController {

    private final DisciplineSemesterService service;

    public DisciplineSemesterController(
            DisciplineSemesterService service
    ) {
        this.service = service;
    }

    @PostMapping
    public DisciplineSemesterResponse create(
            @Valid
            @RequestBody CreateDisciplineSemesterRequest request
    ) {
        return service.create(request);
    }

    @GetMapping
    public List<DisciplineSemesterResponse> getByDiscipline(
            @RequestParam Long programDisciplineId
    ) {
        return service.getByDiscipline(programDisciplineId);
    }
}