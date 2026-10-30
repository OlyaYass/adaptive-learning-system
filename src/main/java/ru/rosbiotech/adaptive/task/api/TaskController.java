package ru.rosbiotech.adaptive.task.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.task.application.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponse create(
            @Valid @RequestBody CreateTaskRequest request
    ) {
        return service.create(request);
    }

    @GetMapping
    public List<TaskResponse> getByTopic(
            @RequestParam Long topicId
    ) {
        return service.getByTopic(topicId);
    }
}