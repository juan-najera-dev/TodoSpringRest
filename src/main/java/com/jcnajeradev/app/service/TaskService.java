package com.jcnajeradev.app.service;

import com.jcnajeradev.app.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public List<Task> getAll();
    public Optional<Task> getById(Long id);
    public Task createTask(Task task);
    public Task updateTask(Task task);
    public void deleteTask(Long id);
}
