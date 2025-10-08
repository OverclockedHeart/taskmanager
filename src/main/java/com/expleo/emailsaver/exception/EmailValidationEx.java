package com.expleo.emailsaver.exception;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class EmailValidationEx {

    @NotNull
    private Long id;

    private String email;
    private String email_censored;
    private String email_hash;


}

