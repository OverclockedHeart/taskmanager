package com.expleo.emailsaver.service;

import java.util.List;

import com.expleo.emailsaver.model.Email;

public interface EmailService {    
    Email createEmail(Email email);
    Email getEmail(Long id);
    Email deleteEmail(Long id);
    List<Email> getAllEmail(Long id);

}
