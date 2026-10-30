package ru.rosbiotech.adaptive.academic.outcome.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateLearningOutcomeRequest(

        @NotNull
        Long programDisciplineId,

        String code,

        @NotBlank
        String description

) {
}