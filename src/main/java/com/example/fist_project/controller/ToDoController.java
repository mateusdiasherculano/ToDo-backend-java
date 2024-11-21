package com.example.fist_project.controller;

import com.example.fist_project.dto.ToDoRequestDTO;
import com.example.fist_project.dto.ToDoResponseDTO;
import com.example.fist_project.entity.ToDo;
import com.example.fist_project.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllTodos() {
        return toDoService.getAll();
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return toDoService.getById(id);
    }

    @PostMapping
    public List<ToDo> create(@Validated @RequestBody ToDo todo){
        return toDoService.create(todo);
    }

    @PutMapping
    public List<ToDo> update( @RequestBody ToDo todo){
        return toDoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<ToDo> delete(@PathVariable Long id){
        return toDoService.delete(id);

    }
}
