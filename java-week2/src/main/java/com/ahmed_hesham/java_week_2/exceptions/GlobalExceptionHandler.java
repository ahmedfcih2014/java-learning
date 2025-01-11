package com.ahmed_hesham.java_week_2.exceptions;

import com.ahmed_hesham.java_week_2.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleValidationException(Exception ex) {
        return new ResponseEntity<>(
                ApiResponse.error(
                        ex, HttpStatus.BAD_REQUEST
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
