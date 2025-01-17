package com.ahmed_hesham.java_week_2.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;

    private String message = "Success";

    private HttpStatus statusCode = HttpStatus.OK;

    public static <T> ApiResponse<T> ok(T data) {
        return ApiResponse.<T>builder()
                .data(data)
                .message("Success")
                .statusCode(HttpStatus.OK)
                .build();
    }

    public static <T> ApiResponse<T> error(Exception e, HttpStatus status) {
        return ApiResponse.<T>builder()
                .data(null)
                .message("Failure: " + e.getMessage())
                .statusCode(status)
                .build();
    }

    public static ApiResponse<Map<String, String>> validation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        String message = errors.entrySet().iterator().next().getValue();
        return ApiResponse.<Map<String, String>>builder()
                .data(errors)
                .message(message)
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY)
                .build();
    }
}
