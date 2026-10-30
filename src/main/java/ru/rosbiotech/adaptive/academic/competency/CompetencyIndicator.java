package ru.rosbiotech.adaptive.academic.competency;

import jakarta.persistence.*;

@Entity
@Table(name = "competency_indicator")
public class CompetencyIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "competency_id", nullable = false)
    private Competency competency;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    protected CompetencyIndicator() {
    }

    public CompetencyIndicator(
            Competency competency,
            String code,
            String description
    ) {
        this.competency = competency;
        this.code = code;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Competency getCompetency() {
        return competency;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}