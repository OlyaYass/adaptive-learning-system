package ru.rosbiotech.adaptive.academic.competency.api;

public record CompetencyIndicatorResponse(
        Long id,
        Long competencyId,
        String code,
        String description
) {
}