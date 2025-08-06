package com.expleo.taskmanager.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHalder {
    
    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<String> handleTaskNotFound(TaskNotFound ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<List<TaskValidationEx>> TaskException(MethodArgumentNotValidException exception) {

    //     List<TaskValidationEx> validation = exception.getBindingResult().getFieldErrors().stream().map(error -> 
    //     new TaskValidationEx(error.getField(), error.getDefaultMessage())).collect(Collectors.toList()); 

    //     return ResponseEntity.badRequest().body(validation);
    // }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationEx>> handleValidationException(MethodArgumentNotValidException exception) {
        
        List<ValidationEx> errors = exception.getBindingResult().getFieldErrors().stream()
            .map(error -> new ValidationEx(error.getField(), error.getDefaultMessage()))
            .collect(Collectors.toList());

    return ResponseEntity.badRequest().body(errors);
}


}
