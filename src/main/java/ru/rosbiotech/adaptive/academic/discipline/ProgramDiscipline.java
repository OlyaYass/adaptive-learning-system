package ru.rosbiotech.adaptive.academic.discipline;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.program.EducationalProgram;

import java.math.BigDecimal;

@Entity
@Table(name = "program_discipline")
public class ProgramDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "educational_program_id", nullable = false)
    private EducationalProgram educationalProgram;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;

    @Column(name = "curriculum_index", nullable = false)
    private String curriculumIndex;

    @Column(nullable = false)
    private BigDecimal credits;

    protected ProgramDiscipline() {
    }

    public Long getId() {
        return id;
    }

    public EducationalProgram getEducationalProgram() {
        return educationalProgram;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public String getCurriculumIndex() {
        return curriculumIndex;
    }

    public BigDecimal getCredits() {
        return credits;
    }
}