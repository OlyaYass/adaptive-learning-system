package ru.rosbiotech.adaptive.task;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDiscipline;

import java.math.BigDecimal;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_discipline_id", nullable = false)
    private ProgramDiscipline programDiscipline;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer difficulty;

    @Column(name = "estimated_minutes")
    private Integer estimatedMinutes;

    @Column(name = "max_score", nullable = false)
    private BigDecimal maxScore;

    @Column(nullable = false)
    private Boolean active = true;

    protected Task() {
    }

    public Task(
            ProgramDiscipline programDiscipline,
            String title,
            String description,
            Integer difficulty,
            Integer estimatedMinutes,
            BigDecimal maxScore
    ) {
        this.programDiscipline = programDiscipline;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.estimatedMinutes = estimatedMinutes;
        this.maxScore = maxScore;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public ProgramDiscipline getProgramDiscipline() {
        return programDiscipline;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public Integer getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public Boolean getActive() {
        return active;
    }
}