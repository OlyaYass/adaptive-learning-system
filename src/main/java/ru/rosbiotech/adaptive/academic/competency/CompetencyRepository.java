package ru.rosbiotech.adaptive.academic.competency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetencyRepository
        extends JpaRepository<Competency, Long> {
}