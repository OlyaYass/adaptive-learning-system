package ru.rosbiotech.adaptive.academic.competency.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.competency.*;
import ru.rosbiotech.adaptive.academic.competency.api.*;

import java.util.List;

@Service
public class CompetencyService {

    private final CompetencyRepository competencyRepository;
    private final CompetencyIndicatorRepository indicatorRepository;

    public CompetencyService(
            CompetencyRepository competencyRepository,
            CompetencyIndicatorRepository indicatorRepository
    ) {
        this.competencyRepository = competencyRepository;
        this.indicatorRepository = indicatorRepository;
    }

    @Transactional
    public CompetencyResponse createCompetency(
            CreateCompetencyRequest request
    ) {

        Competency competency =
                new Competency(
                        request.code(),
                        request.name()
                );

        Competency saved =
                competencyRepository.save(competency);

        return new CompetencyResponse(
                saved.getId(),
                saved.getCode(),
                saved.getName()
        );
    }

    @Transactional
    public CompetencyIndicatorResponse createIndicator(
            CreateCompetencyIndicatorRequest request
    ) {

        Competency competency =
                competencyRepository
                        .findById(request.competencyId())
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Компетенция не найдена"
                                )
                        );

        CompetencyIndicator indicator =
                new CompetencyIndicator(
                        competency,
                        request.code(),
                        request.description()
                );

        CompetencyIndicator saved =
                indicatorRepository.save(indicator);

        return toIndicatorResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CompetencyResponse> getAllCompetencies() {

        return competencyRepository
                .findAll()
                .stream()
                .map(c ->
                        new CompetencyResponse(
                                c.getId(),
                                c.getCode(),
                                c.getName()
                        )
                )
                .toList();
    }

    @Transactional(readOnly = true)
    public List<CompetencyIndicatorResponse> getIndicators(
            Long competencyId
    ) {

        return indicatorRepository
                .findAllByCompetencyId(competencyId)
                .stream()
                .map(this::toIndicatorResponse)
                .toList();
    }

    private CompetencyIndicatorResponse toIndicatorResponse(
            CompetencyIndicator indicator
    ) {

        return new CompetencyIndicatorResponse(
                indicator.getId(),
                indicator.getCompetency().getId(),
                indicator.getCode(),
                indicator.getDescription()
        );
    }
}