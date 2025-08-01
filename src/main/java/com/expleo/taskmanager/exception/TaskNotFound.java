package com.expleo.taskmanager.exception;

public class TaskNotFound extends RuntimeException {

    public TaskNotFound(Long id) {
        super("Task con ID " + id + " non trovato");
    
    }    
}