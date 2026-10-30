package ru.rosbiotech.adaptive.academic.topic;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.competency.CompetencyIndicator;

import java.math.BigDecimal;

@Entity
@Table(name = "topic_indicator")
public class TopicIndicator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "indicator_id", nullable = false)
    private CompetencyIndicator indicator;

    @Column(nullable = false)
    private BigDecimal weight;

    protected TopicIndicator() {
    }

    public TopicIndicator(
            Topic topic,
            CompetencyIndicator indicator,
            BigDecimal weight
    ) {
        this.topic = topic;
        this.indicator = indicator;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public CompetencyIndicator getIndicator() {
        return indicator;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}