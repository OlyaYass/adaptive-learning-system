package ru.rosbiotech.adaptive.academic.outcome;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDiscipline;

@Entity
@Table(name = "learning_outcome")
public class LearningOutcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_discipline_id", nullable = false)
    private ProgramDiscipline programDiscipline;

    @Column(length = 50)
    private String code;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    protected LearningOutcome() {
    }

    public LearningOutcome(
            ProgramDiscipline programDiscipline,
            String code,
            String description
    ) {
        this.programDiscipline = programDiscipline;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public ProgramDiscipline getProgramDiscipline() {
        return programDiscipline;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}