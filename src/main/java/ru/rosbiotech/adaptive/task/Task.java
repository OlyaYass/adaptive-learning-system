package ru.rosbiotech.adaptive.task;

import jakarta.persistence.*;
import ru.rosbiotech.adaptive.academic.topic.Topic;

import java.math.BigDecimal;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

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
            Topic topic,
            String title,
            String description,
            Integer difficulty,
            Integer estimatedMinutes,
            BigDecimal maxScore
    ) {
        this.topic = topic;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.estimatedMinutes = estimatedMinutes;
        this.maxScore = maxScore;
    }

    public Long getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
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