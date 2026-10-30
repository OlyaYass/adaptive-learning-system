package ru.rosbiotech.adaptive.academic.outcome.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDiscipline;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDisciplineRepository;
import ru.rosbiotech.adaptive.academic.outcome.LearningOutcome;
import ru.rosbiotech.adaptive.academic.outcome.LearningOutcomeRepository;
import ru.rosbiotech.adaptive.academic.outcome.api.CreateLearningOutcomeRequest;
import ru.rosbiotech.adaptive.academic.outcome.api.LearningOutcomeResponse;

import java.util.List;

@Service
public class LearningOutcomeService {

    private final LearningOutcomeRepository learningOutcomeRepository;
    private final ProgramDisciplineRepository programDisciplineRepository;

    public LearningOutcomeService(
            LearningOutcomeRepository learningOutcomeRepository,
            ProgramDisciplineRepository programDisciplineRepository
    ) {
        this.learningOutcomeRepository = learningOutcomeRepository;
        this.programDisciplineRepository = programDisciplineRepository;
    }

    @Transactional
    public LearningOutcomeResponse create(
            CreateLearningOutcomeRequest request
    ) {

        ProgramDiscipline programDiscipline =
                programDisciplineRepository
                        .findById(request.programDisciplineId())
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Дисциплина учебного плана не найдена"
                                )
                        );

        LearningOutcome learningOutcome =
                new LearningOutcome(
                        programDiscipline,
                        request.code(),
                        request.description()
                );

        LearningOutcome saved =
                learningOutcomeRepository.save(learningOutcome);

        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<LearningOutcomeResponse> getByDiscipline(
            Long programDisciplineId
    ) {

        return learningOutcomeRepository
                .findAllByProgramDisciplineId(programDisciplineId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private LearningOutcomeResponse toResponse(
            LearningOutcome learningOutcome
    ) {

        return new LearningOutcomeResponse(
                learningOutcome.getId(),
                learningOutcome.getProgramDiscipline().getId(),
                learningOutcome.getCode(),
                learningOutcome.getDescription()
        );
    }
}