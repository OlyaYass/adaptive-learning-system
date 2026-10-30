package ru.rosbiotech.adaptive.academic.semester;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDiscipline;

@Entity
@Table(name = "discipline_semester")
public class DisciplineSemester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "program_discipline_id", nullable = false)
    private ProgramDiscipline programDiscipline;

    @Column(name = "semester_number", nullable = false)
    private Integer semesterNumber;

    @Column(name = "control_type", nullable = false)
    private String controlType;

    @Column(nullable = false)
    private Boolean active = true;

    protected DisciplineSemester() {
    }

    public DisciplineSemester(
            ProgramDiscipline programDiscipline,
            Integer semesterNumber,
            String controlType
    ) {
        this.programDiscipline = programDiscipline;
        this.semesterNumber = semesterNumber;
        this.controlType = controlType;
    }

    public Long getId() {
        return id;
    }

    public ProgramDiscipline getProgramDiscipline() {
        return programDiscipline;
    }

    public Integer getSemesterNumber() {
        return semesterNumber;
    }

    public String getControlType() {
        return controlType;
    }

    public Boolean getActive() {
        return active;
    }
}