package com.example.fist_project.controller;

import com.example.fist_project.dto.ToDoResponseDTO;
import com.example.fist_project.entity.ToDo;
import com.example.fist_project.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ToDoResponseDTO> getAllTodos() {
        return toDoService.getAll();
    }

    @GetMapping("/{id}")
    public ToDoResponseDTO getToDoById(@PathVariable Long id) {
        return toDoService.getById(id);
    }

    @PostMapping
    public List<ToDoResponseDTO> create(@Validated @RequestBody ToDo todo){
        return toDoService.create(todo);
    }

    @PutMapping
    public List<ToDoResponseDTO> update( @RequestBody ToDo todo){
        return toDoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<ToDoResponseDTO> delete(@PathVariable Long id){
        return toDoService.delete(id);

    }
}
