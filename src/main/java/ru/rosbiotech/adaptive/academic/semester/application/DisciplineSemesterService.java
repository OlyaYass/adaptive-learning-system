package ru.rosbiotech.adaptive.academic.semester.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDiscipline;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDisciplineRepository;
import ru.rosbiotech.adaptive.academic.semester.DisciplineSemester;
import ru.rosbiotech.adaptive.academic.semester.DisciplineSemesterRepository;
import ru.rosbiotech.adaptive.academic.semester.api.CreateDisciplineSemesterRequest;
import ru.rosbiotech.adaptive.academic.semester.api.DisciplineSemesterResponse;

import java.util.List;

@Service
public class DisciplineSemesterService {

    private final DisciplineSemesterRepository semesterRepository;
    private final ProgramDisciplineRepository programDisciplineRepository;

    public DisciplineSemesterService(
            DisciplineSemesterRepository semesterRepository,
            ProgramDisciplineRepository programDisciplineRepository
    ) {
        this.semesterRepository = semesterRepository;
        this.programDisciplineRepository = programDisciplineRepository;
    }

    @Transactional
    public DisciplineSemesterResponse create(
            CreateDisciplineSemesterRequest request
    ) {

        ProgramDiscipline programDiscipline =
                programDisciplineRepository
                        .findById(request.programDisciplineId())
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Дисциплина учебного плана не найдена"
                                )
                        );

        DisciplineSemester semester =
                new DisciplineSemester(
                        programDiscipline,
                        request.semesterNumber(),
                        request.controlType()
                );

        return toResponse(
                semesterRepository.save(semester)
        );
    }

    @Transactional(readOnly = true)
    public List<DisciplineSemesterResponse> getByDiscipline(
            Long programDisciplineId
    ) {

        return semesterRepository
                .findAllByProgramDisciplineIdOrderBySemesterNumberAsc(
                        programDisciplineId
                )
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private DisciplineSemesterResponse toResponse(
            DisciplineSemester semester
    ) {

        return new DisciplineSemesterResponse(
                semester.getId(),
                semester.getProgramDiscipline().getId(),
                semester.getSemesterNumber(),
                semester.getControlType(),
                semester.getActive()
        );
    }
}