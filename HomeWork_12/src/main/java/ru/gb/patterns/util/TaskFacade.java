package ru.gb.patterns.util;

import ru.gb.patterns.model.Task;
import ru.gb.patterns.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskFacade {

    private final TaskService taskService;

    @Autowired
    public TaskFacade(TaskService taskService) {
        this.taskService = taskService;
    }

    public Task createTask(String name, String description) {
        Task task = new Task();
        task.setName(name);
        task.setDescription(description);
        return taskService.createTask(task);
    }
}