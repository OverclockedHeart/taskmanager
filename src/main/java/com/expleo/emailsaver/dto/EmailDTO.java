package com.expleo.emailsaver.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDTO {
    
    private Long id;
    private String email;
    private String email_censored;
    private String email_hash;
}
