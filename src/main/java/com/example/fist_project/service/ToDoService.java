package com.example.fist_project.service;

import com.example.fist_project.entity.ToDo;
import com.example.fist_project.repository.ToDoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ToDoService {

    @Autowired
    private final ToDoRepository toDoRepository;

    public List<ToDo> getAll(){
        return toDoRepository.findAll();
    }


    public ToDo getById(Long id){
        return toDoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
    }

    public ToDo create(ToDo toDo){
        return toDoRepository.save(toDo);
    }

    public ToDo update(Long id, ToDo toDo){
        ToDo existingToDo = toDoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not found"));
        existingToDo.updateFrom(toDo);
        return toDoRepository.save(existingToDo);
    }

    public void delete(Long id){
        toDoRepository.deleteById(id);
    }

}
