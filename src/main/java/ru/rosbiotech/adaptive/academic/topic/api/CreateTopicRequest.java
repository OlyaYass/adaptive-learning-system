package ru.rosbiotech.adaptive.academic.topic.api;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateTopicRequest(

        @NotNull
        Long disciplineSemesterId,

        @NotBlank
        String name,

        @NotNull
        @Min(1)
        Integer position,

        @DecimalMin("0.0")
        @DecimalMax("100.0")
        BigDecimal targetMastery

) {
}