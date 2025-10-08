package com.expleo.emailsaver.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expleo.emailsaver.exception.EmailNotFound;
import com.expleo.emailsaver.model.Email;
import com.expleo.emailsaver.repository.EmailRepository;
import com.expleo.emailsaver.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Email createEmail(Email email) {

        return emailRepository.save(email);
    }

    @Override
    public Email getEmail(Long id) {

        return emailRepository.findById(id).orElseThrow(() -> new EmailNotFound(id));
    }

    @Override
    public List<Email> getAllEmail(Long id) {
        
        return emailRepository.findAll();
    }

    @Override
    public Email deleteEmail(Long id) {
        Email email = emailRepository.findById(id).orElseThrow(() -> new EmailNotFound(id));

        emailRepository.deleteById(id);
        
        return email;
    }
}
