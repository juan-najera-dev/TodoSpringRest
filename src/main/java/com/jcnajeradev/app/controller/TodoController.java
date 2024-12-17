package com.jcnajeradev.app.controller;

import com.jcnajeradev.app.model.Task;
import com.jcnajeradev.app.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/api/tasks")
public class TodoController {

    @Autowired
    private ITaskService service;

    @PostMapping(value = "/")
    public ResponseEntity<?> create(@RequestBody Task task){
        Optional<Task> taskTmp = service.getById(task.getId());
        if(taskTmp.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Task newTask = service.createTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(newTask);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Task> task = service.getById(id);
        if(!task.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        Optional<Task> task = service.getById(id);
        if (!task.isPresent()){
            return ResponseEntity.notFound().build();
        }
        updatedTask.setId(id);
        service.updateTask(updatedTask);
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTask(updatedTask));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Task> task = service.getById(id);
        if(!task.isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deleteTask(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping(value = "/")
    public List<Task> readAll(){
        List<Task> tasks = StreamSupport.stream(service.getAll().spliterator(),false).collect(Collectors.toList());
        return tasks;
    }
}
