package com.expleo.emailsaver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expleo.emailsaver.model.Email;
import com.expleo.emailsaver.dto.CreateEmailRequestDTO;
import com.expleo.emailsaver.mapper.EmailMapper;
import com.expleo.emailsaver.service.EmailService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {
    
    private final EmailService emailService;
    private final EmailMapper emailMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmail(@PathVariable Long id) {

        Email email = emailService.getEmail(id);
        return ResponseEntity.ok(email);
    }
    
    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody @Valid CreateEmailRequestDTO createEmail) {
        
        Email email = emailMapper.createEmailToEntity(createEmail);
        Email emailSaved = emailService.createEmail(email);

        return ResponseEntity.ok(emailSaved);
    }

    @DeleteMapping("/{id}")
    public void deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);

    }
}
