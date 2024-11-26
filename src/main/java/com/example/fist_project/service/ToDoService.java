package com.example.fist_project.service;

import com.example.fist_project.dto.ToDoResponseDTO;
import com.example.fist_project.entity.ToDo;
import com.example.fist_project.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;



    // Método para obter todos os ToDos e convertê-los em DTOs
    public List<ToDoResponseDTO> getAll() {
        List<ToDo> todos = toDoRepository.findAll();
        return todos.stream().map(ToDoResponseDTO::convertToDoDTO).collect(Collectors.toList());
    }

    // Método para obter um único ToDo pelo ID e convertê-lo em DTO
    public ToDoResponseDTO getById(Long id) {
        ToDo todo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        return ToDoResponseDTO.convertToDoDTO(todo);

    }

    // Métodos de criação, atualização e exclusão de ToDos
    public List<ToDoResponseDTO> create(ToDo toDo) {
        toDoRepository.save(toDo);
        return getAll();
    }

    public List<ToDoResponseDTO> update(ToDo todo) {
        toDoRepository.save(todo);
        return getAll();
    }

    public List<ToDoResponseDTO> delete(Long id) {
        toDoRepository.deleteById(id);
        return getAll();
    }



}
