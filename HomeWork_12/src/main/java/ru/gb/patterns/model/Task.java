package ru.gb.patterns.model;
import lombok.Data;

@Data
public class Task {

    private Long id;
    private String name;
    private String description;
}