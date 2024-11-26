package com.example.fist_project.dto;

import com.example.fist_project.entity.ToDo;

import lombok.Data;

@Data
public class ToDoResponseDTO {
    private Long id;
    private String title;
    private String description;

    public static ToDoResponseDTO convertToDoDTO(ToDo todo){
        ToDoResponseDTO dto = new ToDoResponseDTO();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setDescription(todo.getDescription());
        return dto;
    }

}
