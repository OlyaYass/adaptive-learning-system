package ru.rosbiotech.adaptive.academic.competency.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCompetencyIndicatorRequest(

        @NotNull
        Long competencyId,

        @NotBlank
        String code,

        @NotBlank
        String description

) {
}