package com.example.todos.taskapp.Service;

import com.example.todos.taskapp.Model.Dto.TaskDto;

import java.util.List;
import java.util.Map;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);
    List<TaskDto> getAllTask();
    TaskDto getTaskById(Long id);
    TaskDto delete(TaskDto taskDto);
    boolean updateTask(Long id, Map<String, Object>update);
}
