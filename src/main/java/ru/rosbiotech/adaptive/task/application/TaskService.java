package ru.rosbiotech.adaptive.task.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDiscipline;
import ru.rosbiotech.adaptive.academic.discipline.ProgramDisciplineRepository;
import ru.rosbiotech.adaptive.task.Task;
import ru.rosbiotech.adaptive.task.TaskRepository;
import ru.rosbiotech.adaptive.task.api.CreateTaskRequest;
import ru.rosbiotech.adaptive.task.api.TaskResponse;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProgramDisciplineRepository programDisciplineRepository;

    public TaskService(
            TaskRepository taskRepository,
            ProgramDisciplineRepository programDisciplineRepository
    ) {
        this.taskRepository = taskRepository;
        this.programDisciplineRepository = programDisciplineRepository;
    }

    @Transactional
    public TaskResponse create(CreateTaskRequest request) {

        ProgramDiscipline programDiscipline =
                programDisciplineRepository
                        .findById(request.programDisciplineId())
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Дисциплина учебного плана не найдена"
                                )
                        );

        Task task = new Task(
                programDiscipline,
                request.title(),
                request.description(),
                request.difficulty(),
                request.estimatedMinutes(),
                request.maxScore()
        );

        return toResponse(taskRepository.save(task));
    }

    @Transactional(readOnly = true)
    public List<TaskResponse> getByDiscipline(
            Long programDisciplineId
    ) {

        return taskRepository
                .findAllByProgramDisciplineIdAndActiveTrue(
                        programDisciplineId
                )
                .stream()
                .map(this::toResponse)
                .toList();
    }

    private TaskResponse toResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getProgramDiscipline().getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDifficulty(),
                task.getEstimatedMinutes(),
                task.getMaxScore(),
                task.getActive()
        );
    }
}