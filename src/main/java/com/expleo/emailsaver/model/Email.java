package com.expleo.emailsaver.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "emails")
public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "email_hash")
    private String email_hash;
    
    @Column(name = "email")
    private String email;

    @Column(name = "email_censored")
    private String email_censored;    
}
