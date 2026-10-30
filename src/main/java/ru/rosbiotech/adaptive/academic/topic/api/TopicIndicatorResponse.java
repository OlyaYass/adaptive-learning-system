package ru.rosbiotech.adaptive.academic.topic.api;

import java.math.BigDecimal;

public record TopicIndicatorResponse(
        Long id,
        Long topicId,
        Long indicatorId,
        String indicatorCode,
        BigDecimal weight
) {
}