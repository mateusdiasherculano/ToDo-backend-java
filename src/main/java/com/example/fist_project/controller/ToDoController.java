package com.example.fist_project.controller;

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
    public ResponseEntity<List<ToDo>> getAllTodos() {
        return ResponseEntity.ok(toDoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ToDo> create(@Validated @RequestBody ToDo toDo){
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(toDo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDo> update(@PathVariable Long id, @RequestBody ToDo toDo){
        return  ResponseEntity.ok(toDoService.update(id,toDo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
    toDoService.delete(id);
    return ResponseEntity.noContent().build();
    }
}
