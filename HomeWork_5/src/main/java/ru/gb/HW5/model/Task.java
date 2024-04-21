package ru.gb.HW5.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    public enum Status {TEMP, NOT_STARTED, IN_PROGRESS, COMPLETED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Status status;
    @Column
    private LocalDateTime local_date_time = LocalDateTime.now();
}
