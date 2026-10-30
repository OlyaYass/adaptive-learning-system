package ru.rosbiotech.adaptive.academic.outcome.api;

public record LearningOutcomeResponse(
        Long id,
        Long programDisciplineId,
        String code,
        String description
) {
}