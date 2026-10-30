package ru.rosbiotech.adaptive.task.api;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CreateTaskRequest(

        @NotNull
        Long topicId,

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        @Min(1)
        @Max(5)
        Integer difficulty,

        @Positive
        Integer estimatedMinutes,

        @NotNull
        @Positive
        BigDecimal maxScore

) {
}