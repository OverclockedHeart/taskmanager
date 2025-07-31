package com.expleo.taskmanager.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String first_name;

    @Column(nullable = false, name = "last_name")
    private String last_name;

    @NotBlank //Check for non-empty email
    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "created_at")
    private LocalDateTime created_at;
    
}
