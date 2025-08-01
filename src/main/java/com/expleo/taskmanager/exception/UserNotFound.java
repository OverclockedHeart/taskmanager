package com.expleo.taskmanager.exception;

public class UserNotFound extends RuntimeException {

    public UserNotFound(Long id) {
        super("Utente con ID " + id + " non trovato");

    }
}