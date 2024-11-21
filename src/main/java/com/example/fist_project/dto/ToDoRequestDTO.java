package com.example.fist_project.dto;



import lombok.Data;
import lombok.NonNull;
@Data
public class ToDoRequestDTO {

    @NonNull
    private String title;
    private String description;
}
