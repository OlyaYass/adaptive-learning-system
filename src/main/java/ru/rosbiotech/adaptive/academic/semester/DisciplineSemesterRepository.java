package ru.rosbiotech.adaptive.academic.semester;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplineSemesterRepository
        extends JpaRepository<DisciplineSemester, Long> {

    List<DisciplineSemester>
    findAllByProgramDisciplineIdOrderBySemesterNumberAsc(
            Long programDisciplineId
    );
}