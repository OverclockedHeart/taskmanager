package com.expleo.emailsaver.exception;

public class EmailNotFound extends RuntimeException {

    public EmailNotFound(Long id) {
        super("Email con ID " + id + " non trovata");

    }
}