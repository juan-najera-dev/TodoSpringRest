package com.jcnajeradev.app.service;

import com.jcnajeradev.app.model.Task;
import com.jcnajeradev.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    TodoRepository repository;

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Task> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task updateTask(Task updatedTask) {
        return repository.save(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
