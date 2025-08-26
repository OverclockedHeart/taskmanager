package com.expleo.taskmanager.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHalder /* extends ResponseEntityExceptionHandler */ {

    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<String> TaskNotFound(TaskNotFound ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> UserNotFound(UserNotFound ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> Exception(Exception ex) {

    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ciao");
    // }

    // Generic Error
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String globalExceptionHandler(Exception ex, WebRequest request) {
        
        return "ERRORE CONTATTARE ADMIN3";
    }

    // @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    // public String defaultExceptionHandler(Exception ex, WebRequest request) {
    // return "ERRORE CONTATTARE ADMIN2";
    // }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<String> Exception(MethodArgumentNotValidException
    // exception) {

    // String errorMsg =
    // exception.getBindingResult().getFieldErrors().get(1).getDefaultMessage();

    // return ResponseEntity.badRequest().body(errorMsg);

    // // return ResponseEntity.badRequest().body(validation);
    // }

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<List<ValidationEx>>
    // handleValidationException(MethodArgumentNotValidException exception) {

    // List<ValidationEx> errors =
    // exception.getBindingResult().getFieldErrors().stream()
    // .map(error -> new ValidationEx(error.getField(), error.getDefaultMessage()))
    // .collect(Collectors.toList());

    // return ResponseEntity.badRequest().body(errors);
    // }
}
