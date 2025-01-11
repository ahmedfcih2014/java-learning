package com.ahmed_hesham.java_week_2.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

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
}
