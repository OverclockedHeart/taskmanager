package com.expleo.taskmanager.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserRequestDTO {
    
    private String firstName;
    private String lastName;
    private String email;

}
