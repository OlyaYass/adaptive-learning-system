package ru.rosbiotech.adaptive.task.api;

import java.math.BigDecimal;

public record TaskResponse(
        Long id,
        Long programDisciplineId,
        String title,
        String description,
        Integer difficulty,
        Integer estimatedMinutes,
        BigDecimal maxScore,
        Boolean active
) {
}