package ru.rosbiotech.adaptive.academic.topic.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.semester.DisciplineSemester;
import ru.rosbiotech.adaptive.academic.semester.DisciplineSemesterRepository;
import ru.rosbiotech.adaptive.academic.topic.Topic;
import ru.rosbiotech.adaptive.academic.topic.TopicRepository;
import ru.rosbiotech.adaptive.academic.topic.api.CreateTopicRequest;
import ru.rosbiotech.adaptive.academic.topic.api.TopicResponse;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;
    private final DisciplineSemesterRepository semesterRepository;

    public TopicService(
            TopicRepository topicRepository,
            DisciplineSemesterRepository semesterRepository
    ) {
        this.topicRepository = topicRepository;
        this.semesterRepository = semesterRepository;
    }

    @Transactional
    public TopicResponse create(CreateTopicRequest request) {

        DisciplineSemester semester =
                semesterRepository
                        .findById(request.disciplineSemesterId())
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Семестр дисциплины не найден"
                                )
                        );

        BigDecimal targetMastery =
                request.targetMastery() != null
                        ? request.targetMastery()
                        : new BigDecimal("75.00");

        Topic topic = new Topic(
                semester,
                request.name(),
                request.position(),
                targetMastery
        );

        return toResponse(topicRepository.save(topic));
    }

    @Transactional(readOnly = true)
    public List<TopicResponse> getBySemester(
            Long disciplineSemesterId
    ) {
        return topicRepository
                .findAllByDisciplineSemesterIdOrderByPositionAsc(
                        disciplineSemesterId
                )
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private TopicResponse toResponse(Topic topic) {

        return new TopicResponse(
                topic.getId(),
                topic.getDisciplineSemester().getId(),
                topic.getName(),
                topic.getPosition(),
                topic.getTargetMastery(),
                topic.getActive()
        );
    }
}