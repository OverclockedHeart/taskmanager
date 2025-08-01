package com.expleo.taskmanager.exception;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
public class UserValidationEx {
    
    @NotBlank
    @Size(min = 2, max = 50)
    private String first_name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String last_name;

    @NotBlank
    @Email
    private String email;
    
}
