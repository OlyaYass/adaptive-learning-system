package ru.rosbiotech.adaptive.academic.discipline.api;

import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.academic.discipline.application.ProgramDisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramDisciplineController {

    private final ProgramDisciplineService service;

    public ProgramDisciplineController(
            ProgramDisciplineService service
    ) {
        this.service = service;
    }

    @GetMapping("/{programCode}/disciplines")
    public List<ProgramDisciplineResponse> getDisciplines(
            @PathVariable String programCode
    ) {
        return service.getProgramDisciplines(programCode);
    }
}