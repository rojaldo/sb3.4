package com.example.demo.errors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.badRequest().body(ErrorDto.builder().message(e.getMessage()).stackTrace(e.getStackTrace().toString()).status(400).build());
        }else if (e instanceof NullPointerException) {
            return ResponseEntity.status(500).body(ErrorDto.builder().message(e.getMessage()).stackTrace(e.getStackTrace().toString()).status(500).build());
        }else if (e instanceof IllegalStateException) {
            return ResponseEntity.status(500).body(ErrorDto.builder().message(e.getMessage()).stackTrace(e.getStackTrace().toString()).status(500).build());
        }else if (e instanceof UnsupportedOperationException) {
            return ResponseEntity.status(500).body(ErrorDto.builder().message(e.getMessage()).stackTrace(e.getStackTrace().toString()).status(500).build());
        }else if (e instanceof DataIntegrityViolationException) {
            return ResponseEntity.status(409).body(ErrorDto.builder().message(e.getMessage()).stackTrace(e.getStackTrace().toString()).status(409).build());
        }

        return ResponseEntity.status(500).body(ErrorDto.builder().message(e.getMessage()).stackTrace(e.getStackTrace().toString()).status(500).build());
    }
    
}
