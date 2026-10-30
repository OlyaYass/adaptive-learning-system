package ru.rosbiotech.adaptive.academic.semester.api;

public record DisciplineSemesterResponse(
        Long id,
        Long programDisciplineId,
        Integer semesterNumber,
        String controlType,
        Boolean active
) {
}