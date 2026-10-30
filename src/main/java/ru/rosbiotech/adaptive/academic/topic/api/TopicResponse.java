package ru.rosbiotech.adaptive.academic.topic.api;

import java.math.BigDecimal;

public record TopicResponse(
        Long id,
        Long disciplineSemesterId,
        String name,
        Integer position,
        BigDecimal targetMastery,
        Boolean active
) {
}