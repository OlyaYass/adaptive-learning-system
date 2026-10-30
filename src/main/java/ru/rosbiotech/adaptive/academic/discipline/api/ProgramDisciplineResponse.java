package ru.rosbiotech.adaptive.academic.discipline.api;

import java.math.BigDecimal;

public record ProgramDisciplineResponse(
        Long id,
        String index,
        String name,
        BigDecimal credits
) {
}