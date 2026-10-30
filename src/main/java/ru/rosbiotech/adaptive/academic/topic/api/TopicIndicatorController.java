package ru.rosbiotech.adaptive.academic.topic.api;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.rosbiotech.adaptive.academic.topic.application.TopicIndicatorService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topic-indicators")
public class TopicIndicatorController {

    private final TopicIndicatorService service;

    public TopicIndicatorController(
            TopicIndicatorService service
    ) {
        this.service = service;
    }

    @PostMapping
    public TopicIndicatorResponse create(
            @Valid
            @RequestBody CreateTopicIndicatorRequest request
    ) {
        return service.create(request);
    }

    @GetMapping
    public List<TopicIndicatorResponse> getByTopic(
            @RequestParam Long topicId
    ) {
        return service.getByTopic(topicId);
    }
}