package ru.rosbiotech.adaptive.academic.semester.api;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateDisciplineSemesterRequest(

        @NotNull
        Long programDisciplineId,

        @NotNull
        @Min(1)
        Integer semesterNumber,

        @NotBlank
        String controlType

) {
}