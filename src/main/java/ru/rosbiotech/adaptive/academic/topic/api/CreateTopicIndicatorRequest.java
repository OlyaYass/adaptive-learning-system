package ru.rosbiotech.adaptive.academic.topic.api;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateTopicIndicatorRequest(

        @NotNull
        Long topicId,

        @NotNull
        Long indicatorId,

        @NotNull
        @DecimalMin("0.0001")
        BigDecimal weight

) {
}