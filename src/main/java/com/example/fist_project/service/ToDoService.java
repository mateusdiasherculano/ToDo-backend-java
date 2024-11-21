package com.example.fist_project.service;

import com.example.fist_project.dto.ToDoRequestDTO;
import com.example.fist_project.dto.ToDoResponseDTO;
import com.example.fist_project.entity.ToDo;
import com.example.fist_project.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@AllArgsConstructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }


    public ToDo getById(Long id) {
        return toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public List<ToDo> create(ToDo toDo) {
        toDoRepository.save(toDo);
        return getAll();
    }

    public List<ToDo> update(ToDo todo) {
        toDoRepository.save(todo);
        return getAll();
    }

    public List<ToDo> delete(Long id) {
        toDoRepository.deleteById(id);
        return getAll();
    }

}
