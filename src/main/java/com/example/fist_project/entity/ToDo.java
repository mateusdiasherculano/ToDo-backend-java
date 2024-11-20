package com.example.fist_project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean done;



    public void updateFrom(ToDo source) {
        if (source.getName() != null) {
            this.name = source.getName();
        }
        if (source.getDone() != null) {
            this.done = source.getDone();
        }
    }
}


