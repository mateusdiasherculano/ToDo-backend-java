package com.example.fist_project.repository;
import com.example.fist_project.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
