package ru.rosbiotech.adaptive.academic.competency;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetencyIndicatorRepository
        extends JpaRepository<CompetencyIndicator, Long> {

    List<CompetencyIndicator> findAllByCompetencyId(Long competencyId);
}