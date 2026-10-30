package ru.rosbiotech.adaptive.academic.outcome;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LearningOutcomeRepository
        extends JpaRepository<LearningOutcome, Long> {

    List<LearningOutcome> findAllByProgramDisciplineId(Long programDisciplineId);
}