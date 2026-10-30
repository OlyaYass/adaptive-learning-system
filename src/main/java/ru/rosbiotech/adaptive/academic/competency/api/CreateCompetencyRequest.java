package ru.rosbiotech.adaptive.academic.competency.api;

import jakarta.validation.constraints.NotBlank;

public record CreateCompetencyRequest(

        @NotBlank
        String code,

        @NotBlank
        String name

) {
}