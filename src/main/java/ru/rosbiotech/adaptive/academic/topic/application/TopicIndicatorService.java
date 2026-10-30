package ru.rosbiotech.adaptive.academic.topic.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.competency.CompetencyIndicator;
import ru.rosbiotech.adaptive.academic.competency.CompetencyIndicatorRepository;
import ru.rosbiotech.adaptive.academic.topic.Topic;
import ru.rosbiotech.adaptive.academic.topic.TopicIndicator;
import ru.rosbiotech.adaptive.academic.topic.TopicIndicatorRepository;
import ru.rosbiotech.adaptive.academic.topic.TopicRepository;
import ru.rosbiotech.adaptive.academic.topic.api.CreateTopicIndicatorRequest;
import ru.rosbiotech.adaptive.academic.topic.api.TopicIndicatorResponse;

import java.util.List;

@Service
public class TopicIndicatorService {

    private final TopicIndicatorRepository topicIndicatorRepository;
    private final TopicRepository topicRepository;
    private final CompetencyIndicatorRepository indicatorRepository;

    public TopicIndicatorService(
            TopicIndicatorRepository topicIndicatorRepository,
            TopicRepository topicRepository,
            CompetencyIndicatorRepository indicatorRepository
    ) {
        this.topicIndicatorRepository = topicIndicatorRepository;
        this.topicRepository = topicRepository;
        this.indicatorRepository = indicatorRepository;
    }

    @Transactional
    public TopicIndicatorResponse create(
            CreateTopicIndicatorRequest request
    ) {

        Topic topic = topicRepository
                .findById(request.topicId())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Тема не найдена"
                        )
                );

        CompetencyIndicator indicator = indicatorRepository
                .findById(request.indicatorId())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Индикатор компетенции не найден"
                        )
                );

        TopicIndicator topicIndicator =
                new TopicIndicator(
                        topic,
                        indicator,
                        request.weight()
                );

        return toResponse(
                topicIndicatorRepository.save(topicIndicator)
        );
    }

    @Transactional(readOnly = true)
    public List<TopicIndicatorResponse> getByTopic(
            Long topicId
    ) {

        return topicIndicatorRepository
                .findAllByTopicId(topicId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private TopicIndicatorResponse toResponse(
            TopicIndicator topicIndicator
    ) {

        return new TopicIndicatorResponse(
                topicIndicator.getId(),
                topicIndicator.getTopic().getId(),
                topicIndicator.getIndicator().getId(),
                topicIndicator.getIndicator().getCode(),
                topicIndicator.getWeight()
        );
    }
}