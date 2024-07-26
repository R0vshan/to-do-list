package com.example.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<Task> getTasksByUserId(UUID userId) {
        return taskRepository.findByUserId(userId);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Integer id, Task taskDetails) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            task.setStartDate(taskDetails.getStartDate());
            task.setEndDate(taskDetails.getEndDate());
            task.setUserId(taskDetails.getUserId());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}