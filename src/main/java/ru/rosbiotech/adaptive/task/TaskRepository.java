package ru.rosbiotech.adaptive.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByTopicIdAndActiveTrue(Long topicId);
}