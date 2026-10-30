package ru.rosbiotech.adaptive.academic.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicIndicatorRepository
        extends JpaRepository<TopicIndicator, Long> {

    List<TopicIndicator> findAllByTopicId(Long topicId);
}