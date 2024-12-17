package com.jcnajeradev.app.repository;


import com.jcnajeradev.app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task, Long> {
}
