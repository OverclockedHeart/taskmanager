package com.expleo.taskmanager.exception;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

// @Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskValidationEx {

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull
    private String status = "TODO";

    @NotNull
    private String priority = "MEDIUM";

    @FutureOrPresent(message = "Date cannot be in the past")
    private LocalDate dueDate;

    @NotNull
    private Long userId;
}

