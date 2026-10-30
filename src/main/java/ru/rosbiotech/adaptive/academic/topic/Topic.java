package ru.rosbiotech.adaptive.academic.topic;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.semester.DisciplineSemester;

import java.math.BigDecimal;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "discipline_semester_id", nullable = false)
    private DisciplineSemester disciplineSemester;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer position;

    @Column(name = "target_mastery", nullable = false)
    private BigDecimal targetMastery = new BigDecimal("75.00");

    @Column(nullable = false)
    private Boolean active = true;

    protected Topic() {
    }

    public Topic(
            DisciplineSemester disciplineSemester,
            String name,
            Integer position,
            BigDecimal targetMastery
    ) {
        this.disciplineSemester = disciplineSemester;
        this.name = name;
        this.position = position;
        this.targetMastery = targetMastery;
    }

    public Long getId() {
        return id;
    }

    public DisciplineSemester getDisciplineSemester() {
        return disciplineSemester;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public BigDecimal getTargetMastery() {
        return targetMastery;
    }

    public Boolean getActive() {
        return active;
    }
}