package ru.rosbiotech.adaptive.academic.topic.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.academic.topic.application.TopicService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topics")
public class TopicController {

    private final TopicService service;

    public TopicController(TopicService service) {
        this.service = service;
    }

    @PostMapping
    public TopicResponse create(
            @Valid @RequestBody CreateTopicRequest request
    ) {
        return service.create(request);
    }

    @GetMapping
    public List<TopicResponse> getBySemester(
            @RequestParam Long disciplineSemesterId
    ) {
        return service.getBySemester(disciplineSemesterId);
    }
}