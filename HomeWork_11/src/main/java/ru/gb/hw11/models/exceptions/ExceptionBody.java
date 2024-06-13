package ru.gb.hw11.models.exceptions;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ExceptionBody {

    private String message;

    private LocalDateTime localDateTime;
}