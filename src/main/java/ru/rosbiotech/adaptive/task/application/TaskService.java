package ru.rosbiotech.adaptive.task.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.topic.Topic;
import ru.rosbiotech.adaptive.academic.topic.TopicRepository;
import ru.rosbiotech.adaptive.task.Task;
import ru.rosbiotech.adaptive.task.TaskRepository;
import ru.rosbiotech.adaptive.task.api.CreateTaskRequest;
import ru.rosbiotech.adaptive.task.api.TaskResponse;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TopicRepository topicRepository;

    public TaskService(
            TaskRepository taskRepository,
            TopicRepository topicRepository
    ) {
        this.taskRepository = taskRepository;
        this.topicRepository = topicRepository;
    }

    @Transactional
    public TaskResponse create(CreateTaskRequest request) {

        Topic topic = topicRepository
                .findById(request.topicId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Тема не найдена")
                );

        Task task = new Task(
                topic,
                request.title(),
                request.description(),
                request.difficulty(),
                request.estimatedMinutes(),
                request.maxScore()
        );

        return toResponse(taskRepository.save(task));
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> getByTopic(Long topicId) {

        return taskRepository
                .findAllByTopicIdAndActiveTrue(topicId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private TaskResponse toResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTopic().getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDifficulty(),
                task.getEstimatedMinutes(),
                task.getMaxScore(),
                task.getActive()
        );
    }
}