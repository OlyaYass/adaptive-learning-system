package ru.rosbiotech.adaptive.academic.discipline.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDisciplineRepository;
import ru.rosbiotech.adaptive.academic.discipline.api.ProgramDisciplineResponse;

import java.util.List;

@Service
public class ProgramDisciplineService {

    private final ProgramDisciplineRepository repository;

    public ProgramDisciplineService(
            ProgramDisciplineRepository repository
    ) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ProgramDisciplineResponse> getProgramDisciplines(
            String programCode
    ) {

        return repository.findAllByProgramCode(programCode)
                .stream()
                .map(programDiscipline ->
                        new ProgramDisciplineResponse(
                                programDiscipline.getId(),
                                programDiscipline.getCurriculumIndex(),
                                programDiscipline.getDiscipline().getName(),
                                programDiscipline.getCredits()
                        )
                )
                .toList();
    }
}